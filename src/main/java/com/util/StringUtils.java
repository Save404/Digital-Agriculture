package com.util;

public class StringUtils {

    public static Boolean isEmpty(String str) {
        if(str == null || str.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
