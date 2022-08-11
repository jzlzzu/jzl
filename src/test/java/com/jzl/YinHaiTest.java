package com.jzl;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class YinHaiTest {

    private static final Map<String, String> map = new HashMap<>();
    private static final String yhCode = "H41010500002";

    @Test
    public void tt() throws Exception {
       queryMpcOrg("H41010500002");
    }
    public void queryMpcOrg(String fixmedinsCode) throws Exception {
        if (chkOrg(fixmedinsCode))
            throw new Exception("null");
        if (chkOrg("99"))
            throw new Exception("null");
        if (chkOrg("98") && chkOrg(map.get(fixmedinsCode)))
            throw new Exception("null");
        if (chkOrg("97") && !chkOrg(map.get(fixmedinsCode)))
            throw new Exception("null");
    }

    static {
        map.put("H41010500003", "1");
        map.put("H41010500002", "2");
        map.put("H41010500030", "3");
        map.put("H41018100413", "4");
        map.put("H41010300013", "5");
        map.put("H41010400010", "6");
        map.put("H41010300011", "7");
        map.put("H41010300021", "8");
        map.put("H41010500022", "9");
        map.put("H41018500014", "10");
        map.put("H41018400978", "11");
        map.put("H41018300214", "12");
        map.put("H41018400120", "13");
        map.put("H41012200054", "14");
        map.put("H41010500025", "15");
        map.put("H41010500008", "16");
        map.put("H41040300001", "17");
        map.put("H41040200079", "18");
        map.put("H41040200202", "19");
        map.put("H41040200117", "20");
        map.put("H41108200151", "21");
        map.put("H41100200007", "22");
        map.put("H41102400182", "23");
        map.put("H41108100235", "24");
        map.put("H41110400007", "25");
        map.put("H41110300012", "26");
        map.put("H41170201006", "27");
        map.put("H41170200115", "28");
        map.put("H41140301138", "29");
        map.put("H41148100367", "30");
        map.put("H41142101238", "31");
        map.put("H41130200745", "32");
        map.put("H41130200746", "33");
        map.put("H41160200010", "34");
        map.put("H41160200057", "35");
        map.put("H41160200049", "36");
        map.put("H41120200102", "37");
        map.put("H41120200082", "38");
        map.put("H41120200090", "39");
        map.put("H41150200007", "40");
        map.put("H41150300093", "41");
        map.put("H41152800161", "42");
        map.put("H41020200094", "43");
        map.put("H41020200109", "44");
        map.put("H41020400097", "45");
        map.put("H41030500412", "46");
        map.put("H41030300170", "47");
        map.put("H41030300122", "48");
        map.put("H41030502919", "49");
        map.put("H41050200002", "50");
        map.put("H41050300015", "51");
        map.put("H41050300010", "52");
        map.put("H41050200007", "53");
        map.put("H41070301544", "54");
        map.put("H41070301545", "55");
        map.put("H41078303612", "56");
        map.put("H41070201191", "57");
        map.put("H41090200004", "58");
        map.put("H41090200016", "59");
        map.put("H41090200009", "60");
        map.put("H41061100012", "61");
        map.put("H41062100132", "62");
        map.put("H41081100114", "63");
        map.put("H41080200169", "64");
        map.put("H41080200170", "65");
        map.put("H41900100011", "66");
        map.put("H41900100010", "67");
    }



    private boolean chkOrg(String s) {
        String[] split = yhCode.split(",");
        List<String> yhCodeList = Arrays.asList(split);
        return yhCodeList.contains(s);
    }
}

