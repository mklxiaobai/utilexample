package com.utilexample.utilexample.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 马锴梁
 * @version 1.0
 * @date 2019/12/12 18:52
 */
public class DataUtil {
    public static String transData(Long timeStamp ){
        SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(timeStamp);
        String day = simpleDateFormat.format(date);
        return day;
    }
    public static String getData(){
        SimpleDateFormat  simpleDateFormat= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        String day = simpleDateFormat.format(date);
        return day;
    }
}
