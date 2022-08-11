package com.jzl.utils;

/**
 * @Author: jiazhaoliang@zsnetwork.com
 * @Description:
 * @Date: Created in 2022/7/19 19:11
 * @Modified By:
 */
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECPoint;

public class SM2KeyPair {
    private final ECPoint publicKey;
    private final BigInteger privateKey;

    public SM2KeyPair(ECPoint publicKey, BigInteger privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public ECPoint getPublicKey() {
        return this.publicKey;
    }

    public BigInteger getPrivateKey() {
        return this.privateKey;
    }
}