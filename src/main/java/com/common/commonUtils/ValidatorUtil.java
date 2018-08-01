package com.common.commonUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {

    public static final Pattern TELEPHONE_PATTERN = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
    public static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    public static final Pattern ID_CARD_PATTERN_15 = Pattern.compile("^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2]" +
            "[1-9])|10|20|30|31)\\d{2}[0-9Xx]$");
    public static final Pattern ID_CARD_PATTERN_18 = Pattern.compile("^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|" +
            "(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");

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
    public static boolean isIdCard(String src) {
        if(StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher matcher = ID_CARD_PATTERN_15.matcher(src);
        Matcher matcher1 = ID_CARD_PATTERN_18.matcher(src);
        if(matcher.matches() || matcher1.matches()) {
            return true;
        } else {
            return false;
        }
    }
}
