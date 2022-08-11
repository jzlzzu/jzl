package com.jzl.utils;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.ShortenedDigest;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.math.ec.ECCurve.Fp;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.pqc.math.linearalgebra.ByteUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: jiazhaoliang@zsnetwork.com
 * @Description:
 * @Date: Created in 2022/7/19 19:02
 * @Modified By:
 */
public class SM2Util {

    private static BigInteger n = new BigInteger("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123", 16);
    private static BigInteger p = new BigInteger("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF", 16);
    private static BigInteger a = new BigInteger("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC", 16);
    private static BigInteger b = new BigInteger("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93", 16);
    private static BigInteger gx = new BigInteger("32C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7", 16);
    private static BigInteger gy = new BigInteger("BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0", 16);
    private static ECDomainParameters ecc_bc_spec;
    private static int w;
    private static BigInteger _2w;
    private static final int DIGEST_LENGTH = 32;
    private static SecureRandom random;
    private static Fp curve;
    private static ECPoint G;

    public SM2Util() {
    }

    public static void printHexString(byte[] b) {
        for(int i = 0; i < b.length; ++i) {
            String hex = Integer.toHexString(b[i] & 255);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }

            System.out.print(hex.toUpperCase());
        }

        System.out.println();
    }

    private static BigInteger random(BigInteger max) {
        BigInteger r;
        for(r = new BigInteger(256, random); r.compareTo(max) >= 0; r = new BigInteger(128, random)) {
        }

        return r;
    }

    private static boolean allZero(byte[] buffer) {
        for(int i = 0; i < buffer.length; ++i) {
            if (buffer[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static String encrypt(String input, ECPoint publicKey) {
        byte[] inputBuffer = input.getBytes();

        byte[] C1Buffer;
        ECPoint kpb;
        byte[] t;
        do {
            BigInteger k = random(n);
            ECPoint C1 = G.multiply(k);
            C1Buffer = C1.getEncoded(false);
            BigInteger h = ecc_bc_spec.getH();
            if (h != null) {
                ECPoint S = publicKey.multiply(h);
                if (S.isInfinity()) {
                    throw new IllegalStateException();
                }
            }

            kpb = publicKey.multiply(k).normalize();
            byte[] kpbBytes = kpb.getEncoded(false);
            t = KDF(kpbBytes, inputBuffer.length);
        } while(allZero(t));

        byte[] C2 = new byte[inputBuffer.length];

        for(int i = 0; i < inputBuffer.length; ++i) {
            C2[i] = (byte)(inputBuffer[i] ^ t[i]);
        }

        byte[] C3 = sm3hash(kpb.getXCoord().toBigInteger().toByteArray(), inputBuffer, kpb.getYCoord().toBigInteger().toByteArray());
        byte[] encryptResult = new byte[C1Buffer.length + C2.length + C3.length];
        System.arraycopy(C1Buffer, 0, encryptResult, 0, C1Buffer.length);
        System.arraycopy(C2, 0, encryptResult, C1Buffer.length, C2.length);
        System.arraycopy(C3, 0, encryptResult, C1Buffer.length + C2.length, C3.length);
        return ByteUtils.toHexString(encryptResult);
    }

    public static String decrypt(String encryptDataStr, BigInteger privateKey) {
        byte[] encryptData = ByteUtils.fromHexString(encryptDataStr);
        byte[] C1Byte = new byte[65];
        System.arraycopy(encryptData, 0, C1Byte, 0, C1Byte.length);
        ECPoint C1 = curve.decodePoint(C1Byte).normalize();
        BigInteger h = ecc_bc_spec.getH();
        ECPoint dBC1;
        if (h != null) {
            dBC1 = C1.multiply(h);
            if (dBC1.isInfinity()) {
                throw new IllegalStateException();
            }
        }

        dBC1 = C1.multiply(privateKey).normalize();
        byte[] dBC1Bytes = dBC1.getEncoded(false);
        int klen = encryptData.length - 65 - 32;
        byte[] t = KDF(dBC1Bytes, klen);
        if (allZero(t)) {
            System.err.println("all zero");
            throw new IllegalStateException();
        } else {
            byte[] M = new byte[klen];

            for(int i = 0; i < M.length; ++i) {
                M[i] = (byte)(encryptData[C1Byte.length + i] ^ t[i]);
            }

            byte[] C3 = new byte[32];
            System.arraycopy(encryptData, encryptData.length - 32, C3, 0, 32);
            byte[] var12 = sm3hash(dBC1.getXCoord().toBigInteger().toByteArray(), M, dBC1.getYCoord().toBigInteger().toByteArray());

            try {
                return new String(M, "UTF8");
            } catch (UnsupportedEncodingException var14) {
                var14.printStackTrace();
                return null;
            }
        }
    }

    private byte[] calculateHash(BigInteger x2, byte[] M, BigInteger y2) {
        ShortenedDigest digest = new ShortenedDigest(new SHA256Digest(), 32);
        byte[] buf = x2.toByteArray();
        digest.update(buf, 0, buf.length);
        digest.update(M, 0, M.length);
        buf = y2.toByteArray();
        digest.update(buf, 0, buf.length);
        buf = new byte[32];
        digest.doFinal(buf, 0);
        return buf;
    }

    private static boolean between(BigInteger param, BigInteger min, BigInteger max) {
        return param.compareTo(min) >= 0 && param.compareTo(max) < 0;
    }

    private static boolean checkPublicKey(ECPoint publicKey) {
        if (!publicKey.isInfinity()) {
            BigInteger x = publicKey.getXCoord().toBigInteger();
            BigInteger y = publicKey.getYCoord().toBigInteger();
            if (between(x, new BigInteger("0"), p) && between(y, new BigInteger("0"), p)) {
                BigInteger xResult = x.pow(3).add(a.multiply(x)).add(b).mod(p);
                BigInteger yResult = y.pow(2).mod(p);
                if (yResult.equals(xResult) && publicKey.multiply(n).isInfinity()) {
                    return true;
                }
            }
        }

        return false;
    }

    public static SM2KeyPair generateKeyPair() {
        BigInteger d = getPriKey();
        SM2KeyPair keyPair = new SM2KeyPair(G.multiply(d).normalize(), d);
        return checkPublicKey(keyPair.getPublicKey()) ? keyPair : null;
    }

    public static ECPoint getPubKeyByPriKey(BigInteger d) {
        SM2KeyPair keyPair = new SM2KeyPair(G.multiply(d).normalize(), d);
        return checkPublicKey(keyPair.getPublicKey()) ? keyPair.getPublicKey() : null;
    }

    public static BigInteger getPriKey() {
        BigInteger d = random(n.subtract(new BigInteger("1")));
        return d;
    }

    public void exportPublicKey(ECPoint publicKey, String path) {
        File file = new File(path);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            byte[] buffer = publicKey.getEncoded(false);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(buffer);
            fos.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }

    private static byte[] join(byte[]... params) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] res = null;

        try {
            for(int i = 0; i < params.length; ++i) {
                baos.write(params[i]);
            }

            res = baos.toByteArray();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return res;
    }

    private static byte[] sm3hash(byte[]... params) {
        byte[] res = null;

        try {
            res = SM3Util.hash(join(params));
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        return res;
    }

    private static byte[] ZA(String IDA, ECPoint aPublicKey) {
        byte[] idaBytes = IDA.getBytes();
        int entlenA = idaBytes.length * 8;
        byte[] ENTLA = new byte[]{(byte)(entlenA & '\uff00'), (byte)(entlenA & 255)};
        byte[] ZA = sm3hash(ENTLA, idaBytes, a.toByteArray(), b.toByteArray(), gx.toByteArray(), gy.toByteArray(), aPublicKey.getXCoord().toBigInteger().toByteArray(), aPublicKey.getYCoord().toBigInteger().toByteArray());
        return ZA;
    }

    public static String sign(String M, String IDA, String privateKeyStr) {
        Decoder decoder = Base64.getDecoder();
        BigInteger privateKey = new BigInteger(decoder.decode(privateKeyStr.getBytes(StandardCharsets.UTF_8)));
        byte[] ZA = ZA(IDA, getPubKeyByPriKey(privateKey));
        byte[] M_ = join(ZA, M.getBytes());
        BigInteger e = new BigInteger(1, sm3hash(M_));

        BigInteger k;
        BigInteger r;
        do {
            do {
                k = random(n);
                ECPoint p1 = G.multiply(k).normalize();
                BigInteger x1 = p1.getXCoord().toBigInteger();
                r = e.add(x1);
                r = r.mod(n);
            } while(r.equals(BigInteger.ZERO));
        } while(r.add(k).equals(n));

        BigInteger s = privateKey.add(BigInteger.ONE).modInverse(n).multiply(k.subtract(r.multiply(privateKey)).mod(n)).mod(n);
        Encoder encoder = Base64.getEncoder();
        String signResult = encoder.encodeToString((new Signature(r, s)).toString().getBytes(StandardCharsets.UTF_8));
        return signResult;
    }

    public static boolean verify(String M, String signatureStr, String IDA, String PublicKey) {
        Decoder decoder = Base64.getDecoder();
        String signStr = new String(decoder.decode(signatureStr.getBytes(StandardCharsets.UTF_8)));
        String[] signData = signStr.split(",");
        Signature signature = new Signature(new BigInteger(signData[0]), new BigInteger(signData[1]));
        ECPoint aPublicKey = null;

        try {
            aPublicKey = getPublicKeyByKeyPairStr(PublicKey);
        } catch (Exception var16) {
            var16.printStackTrace();
        }

        if (!between(signature.r, BigInteger.ONE, n)) {
            return false;
        } else if (!between(signature.s, BigInteger.ONE, n)) {
            return false;
        } else {
            byte[] M_ = join(ZA(IDA, aPublicKey), M.getBytes());
            BigInteger e = new BigInteger(1, sm3hash(M_));
            BigInteger t = signature.r.add(signature.s).mod(n);
            if (t.equals(BigInteger.ZERO)) {
                return false;
            } else {
                ECPoint p1 = G.multiply(signature.s).normalize();
                ECPoint p2 = aPublicKey.multiply(t).normalize();
                BigInteger x1 = p1.add(p2).normalize().getXCoord().toBigInteger();
                BigInteger R = e.add(x1).mod(n);
                return R.equals(signature.r);
            }
        }
    }

    private static byte[] KDF(byte[] Z, int klen) {
        int ct = 1;
        int end = (int)Math.ceil((double)klen * 1.0D / 32.0D);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            for(int i = 1; i < end; ++i) {
                baos.write(sm3hash(Z, SM3Util.toByteArray(ct)));
                ++ct;
            }

            byte[] last = sm3hash(Z, SM3Util.toByteArray(ct));
            if (klen % 32 == 0) {
                baos.write(last);
            } else {
                baos.write(last, 0, klen % 32);
            }

            return baos.toByteArray();
        } catch (Exception var6) {
            var6.printStackTrace();
            return null;
        }
    }

    public static void keyAgreement(String aID, String bID) {
        SM2KeyPair aKeyPair = generateKeyPair();
        KeyExchange aKeyExchange = new KeyExchange(aID, aKeyPair);
        SM2KeyPair bKeyPair = generateKeyPair();
        KeyExchange bKeyExchange = new KeyExchange(bID, bKeyPair);
        TransportEntity entity1 = aKeyExchange.keyExchange_1();
        TransportEntity entity2 = bKeyExchange.keyExchange_2(entity1);
        TransportEntity entity3 = aKeyExchange.keyExchange_3(entity2);
        printHexString(bKeyExchange.keyExchange_4(entity3).Z);
    }

    public static Map<String, String> getKeyPairStr() {
        Encoder encoder = Base64.getEncoder();
        SM2KeyPair key = generateKeyPair();
        String privateKey = encoder.encodeToString(key.getPrivateKey().toByteArray());
        String publicKey = encoder.encodeToString(key.getPublicKey().getEncoded(false));
        Map<String, String> keyMap = new HashMap();
        keyMap.put("publicKey", publicKey);
        keyMap.put("privateKey", privateKey);
        return keyMap;
    }

    public static ECPoint getPublicKeyByKeyPairStr(String keyPairStr) throws Exception {
        Decoder decoder = Base64.getDecoder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(decoder.decode(keyPairStr.getBytes(StandardCharsets.UTF_8)));
        ECPoint ecPoint = curve.decodePoint(baos.toByteArray());
        return ecPoint;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        Map<String, String> map = getKeyPairStr();
        System.out.println("-----------------签名与验签-----------------");
        System.out.println("公私钥：" + map.toString());
        String IDA = "123456789";
        String M = "要签名的信息";
        System.out.println("用户标识:" + IDA);
        System.out.println("签名信息:" + M);
        String signature = sign(M, IDA, (String)map.get("privateKey"));
        System.out.println("shuziqia*nmin:" + signature);
        System.out.println("验证签名:" + verify(M, signature, IDA, (String)map.get("publicKey")));
    }

    static {
        w = (int)Math.ceil((double)n.bitLength() * 1.0D / 2.0D) - 1;
        _2w = (new BigInteger("2")).pow(w);
        random = new SecureRandom();
        curve = new Fp(p, a, b);
        G = curve.createPoint(gx, gy);
        ecc_bc_spec = new ECDomainParameters(curve, G, n);
    }

    public static class KeyExchange {
        BigInteger rA;
        ECPoint RA;
        ECPoint V;
        byte[] Z;
        byte[] key;
        String ID;
        SM2KeyPair keyPair;

        public KeyExchange(String ID, SM2KeyPair keyPair) {
            this.ID = ID;
            this.keyPair = keyPair;
            this.Z = SM2Util.ZA(ID, keyPair.getPublicKey());
        }

        public TransportEntity keyExchange_1() {
            this.rA = SM2Util.random(SM2Util.n);
            this.RA = SM2Util.G.multiply(this.rA).normalize();
            return new TransportEntity(this.RA.getEncoded(false), (byte[])null, this.Z, this.keyPair.getPublicKey());
        }

        public TransportEntity keyExchange_2(TransportEntity entity) {
            BigInteger rB = SM2Util.random(SM2Util.n);
            ECPoint RB = SM2Util.G.multiply(rB).normalize();
            this.rA = rB;
            this.RA = RB;
            BigInteger x2 = RB.getXCoord().toBigInteger();
            x2 = SM2Util._2w.add(x2.and(SM2Util._2w.subtract(BigInteger.ONE)));
            BigInteger tB = this.keyPair.getPrivateKey().add(x2.multiply(rB)).mod(SM2Util.n);
            ECPoint RA = SM2Util.curve.decodePoint(entity.R).normalize();
            BigInteger x1 = RA.getXCoord().toBigInteger();
            x1 = SM2Util._2w.add(x1.and(SM2Util._2w.subtract(BigInteger.ONE)));
            ECPoint aPublicKey = SM2Util.curve.decodePoint(entity.K).normalize();
            ECPoint temp = aPublicKey.add(RA.multiply(x1).normalize()).normalize();
            ECPoint V = temp.multiply(SM2Util.ecc_bc_spec.getH().multiply(tB)).normalize();
            if (V.isInfinity()) {
                throw new IllegalStateException();
            } else {
                this.V = V;
                byte[] xV = V.getXCoord().toBigInteger().toByteArray();
                byte[] yV = V.getYCoord().toBigInteger().toByteArray();
                byte[] KB = SM2Util.KDF(SM2Util.join(xV, yV, entity.Z, this.Z), 16);
                this.key = KB;
                System.out.print("协商得B密钥:");
                SM2Util.printHexString(KB);
                byte[] sB = SM2Util.sm3hash(new byte[]{2}, yV, SM2Util.sm3hash(xV, entity.Z, this.Z, RA.getXCoord().toBigInteger().toByteArray(), RA.getYCoord().toBigInteger().toByteArray(), RB.getXCoord().toBigInteger().toByteArray(), RB.getYCoord().toBigInteger().toByteArray()));
                return new TransportEntity(RB.getEncoded(false), sB, this.Z, this.keyPair.getPublicKey());
            }
        }

        public TransportEntity keyExchange_3(TransportEntity entity) {
            BigInteger x1 = this.RA.getXCoord().toBigInteger();
            x1 = SM2Util._2w.add(x1.and(SM2Util._2w.subtract(BigInteger.ONE)));
            BigInteger tA = this.keyPair.getPrivateKey().add(x1.multiply(this.rA)).mod(SM2Util.n);
            ECPoint RB = SM2Util.curve.decodePoint(entity.R).normalize();
            BigInteger x2 = RB.getXCoord().toBigInteger();
            x2 = SM2Util._2w.add(x2.and(SM2Util._2w.subtract(BigInteger.ONE)));
            ECPoint bPublicKey = SM2Util.curve.decodePoint(entity.K).normalize();
            ECPoint temp = bPublicKey.add(RB.multiply(x2).normalize()).normalize();
            ECPoint U = temp.multiply(SM2Util.ecc_bc_spec.getH().multiply(tA)).normalize();
            if (U.isInfinity()) {
                throw new IllegalStateException();
            } else {
                this.V = U;
                byte[] xU = U.getXCoord().toBigInteger().toByteArray();
                byte[] yU = U.getYCoord().toBigInteger().toByteArray();
                byte[] KA = SM2Util.KDF(SM2Util.join(xU, yU, this.Z, entity.Z), 16);
                this.key = KA;
                System.out.print("协商得A密钥:");
                SM2Util.printHexString(KA);
                byte[] s1 = SM2Util.sm3hash(new byte[]{2}, yU, SM2Util.sm3hash(xU, this.Z, entity.Z, this.RA.getXCoord().toBigInteger().toByteArray(), this.RA.getYCoord().toBigInteger().toByteArray(), RB.getXCoord().toBigInteger().toByteArray(), RB.getYCoord().toBigInteger().toByteArray()));
                if (Arrays.equals(entity.S, s1)) {
                    System.out.println("B->A 密钥确认成功");
                } else {
                    System.out.println("B->A 密钥确认失败");
                }

                byte[] sA = SM2Util.sm3hash(new byte[]{3}, yU, SM2Util.sm3hash(xU, this.Z, entity.Z, this.RA.getXCoord().toBigInteger().toByteArray(), this.RA.getYCoord().toBigInteger().toByteArray(), RB.getXCoord().toBigInteger().toByteArray(), RB.getYCoord().toBigInteger().toByteArray()));
                return new TransportEntity(this.RA.getEncoded(false), sA, this.Z, this.keyPair.getPublicKey());
            }
        }

        public TransportEntity keyExchange_4(TransportEntity entity) {
            byte[] xV = this.V.getXCoord().toBigInteger().toByteArray();
            byte[] yV = this.V.getYCoord().toBigInteger().toByteArray();
            ECPoint RA = SM2Util.curve.decodePoint(entity.R).normalize();
            byte[] s2 = SM2Util.sm3hash(new byte[]{3}, yV, SM2Util.sm3hash(xV, entity.Z, this.Z, RA.getXCoord().toBigInteger().toByteArray(), RA.getYCoord().toBigInteger().toByteArray(), this.RA.getXCoord().toBigInteger().toByteArray(), this.RA.getYCoord().toBigInteger().toByteArray()));
            if (Arrays.equals(entity.S, s2)) {
                System.out.println("A->B 密钥确认成功");
                return entity;
            } else {
                System.out.println("A->B 密钥确认失败");
                return entity;
            }
        }
    }

    public static class Signature {
        BigInteger r;
        BigInteger s;

        public Signature(BigInteger r, BigInteger s) {
            this.r = r;
            this.s = s;
        }

        public String toString() {
            return this.r + "," + this.s;
        }
    }

    private static class TransportEntity implements Serializable {
        final byte[] R;
        final byte[] S;
        final byte[] Z;
        final byte[] K;

        public TransportEntity(byte[] r, byte[] s, byte[] z, ECPoint pKey) {
            this.R = r;
            this.S = s;
            this.Z = z;
            this.K = pKey.getEncoded(false);
        }
    }

}
