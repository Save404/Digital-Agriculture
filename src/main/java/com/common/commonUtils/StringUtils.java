package com.common.commonUtils;

public class StringUtils {

    public static Boolean isEmpty(String str) {
        if(str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 给传入的字符串添加单引号
     * 供sql包下的类调用
     * @param str
     * @return
     */
    public static String addQuotationMarks(String str){
        return "'" + str + "'";
    }
}
