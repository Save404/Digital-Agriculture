package com.util.commonUtils;

public class SaltUtil {

    private static String str = "abcdefghijklmnopqrstuvwxyz";

    private static int getRandom(int len) {
        return (int)Math.round((Math.random() * len));
    }

    /**
     * 随机生成第二次加密使用的salt
     * @param length salt的长度 建议大于6
     * @return salt字符串
     */
    public static String getSalt(int length) {
        StringBuffer sb = new StringBuffer();
        int len = str.length();
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(getRandom(len - 1)));
        }
        return sb.toString();
    }
}
