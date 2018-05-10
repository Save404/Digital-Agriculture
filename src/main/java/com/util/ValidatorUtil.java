package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    public static final Pattern TELEPHONE_PATTERN = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");

    public static boolean isTelephone(String src) {
        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher matcher = TELEPHONE_PATTERN.matcher(src);
        return matcher.matches();
    }
    public static boolean isEmail(String src) {
        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(src);
        return matcher.matches();
    }
}
