//package com.jzl.ql;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
///**
// * @Author: jiazhaoliang@zsnetwork.com
// * @Description:
// * @Date: Created in 2022/7/1 9:52
// * @Modified By:
// */
//public class YbTest1 {
//    public static void main(String[] args) {
//        import java.text.SimpleDateFormat;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
//        currentflag = false;
//        for ( i = 0; i < psninsu.size(); i++) {
//            item = psninsu.get(i);
//            if ("1".equals(item.getPsnInsuStas()) && "390".equals(item.getInsutype())) {
//                currentflag = true;
//                break;
//            }
//        }
//        if(!currentflag){
//            return currentflag;
//        }
//        settleTime = new Date();
//        Calendar c = Calendar.getInstance();
//        c.setTime(settleTime);
//        String cashM = sdf.format(c.getTime());
//        currentflag = false;
//        for ( i = 0; i < rsdtPsnClctDetlList.size(); i++) {
//            item = rsdtPsnClctDetlList.get(i);
//            if (cashM.compareTo(item.getAccrymBegn()) >= 0 && cashM.compareTo(item.getAccrymEnd()) <= 0 && "1".equals(item.getClctFlag()) && "390".equals(item.getInsutype())) {
//                currentflag = true;
//                break;
//            }
//        }
//        if(!currentflag){
//            return currentflag;
//        }
//        currentflag = false;
//        for ( i = 0; i < psninsu.size(); i++) {
//            item = psninsu.get(i);
//            if ("1".equals(item.getPsnInsuStas()) && "411".equals(item.getInsutype())) {
//                currentflag = true;
//                break;
//            }
//        }
//        if(!currentflag){
//            return currentflag;
//        }
//        return currentflag;
//    }
//}
