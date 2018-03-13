package com.sleep.myUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SuperDate {

    /**
     * 日期格式，年月日时分，例如：200506301210，200808081210
     */
    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";


    // ==格式到年月日 时分秒==
    /**
     * 日期格式，年月日时分秒，例如：20001230120000，20080808200808
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    // ==格式到年月日 时分秒 毫秒==
    /**
     * 日期格式，年月日时分秒毫秒，例如：20001230120000123，20080808200808456
     */
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";

    public static String getNowStr(){
        DateFormat dateFormat=new SimpleDateFormat(DATE_TIME_FORMAT_YYYYMMDDHHMISS);
        return dateFormat.format(new Date());
    }
}
