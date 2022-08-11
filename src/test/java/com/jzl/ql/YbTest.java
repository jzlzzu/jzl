package com.jzl.ql;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: jiazhaoliang@zsnetwork.com
 * @Description:
 * @Date: Created in 2022/6/30 18:38
 * @Modified By:
 */
public class YbTest {


    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
        Date settleTime = new Date();
        String format = sdf.format(settleTime);
        System.out.println(format);

        Calendar c = Calendar.getInstance();
        c.setTime(settleTime);
        c.add(Calendar.MONTH, -1);
        String cashM1=sdf.format(c.getTime());
        System.out.println(cashM1);

        if (cashM1.compareTo("202201111111111") >= 0 && cashM1.compareTo("202212") <= 0) {
            System.out.println("return false");
        }
        System.out.println("----");


    }


}
