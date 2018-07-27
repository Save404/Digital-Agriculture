package com.common.commonUtils;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {

    private static final String salt = "z0fdf7f8g9o1";

    private static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    /**
     * 将表单输入的密码进行第一次MD5加密
     * @param inputPass 表单输入的密码字符串
     * @return 加密后的密码字符串
     */
    private static String inputPassToFormPass(String inputPass) {
        String  str =
                "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt;
        return md5(str);
    }

    /**
     * 将密码进行第二次加密
     * @param formPass 第一次加密后的密码字符串
     * @param salt 随机生成的salt字符串
     * @return 加密后的密码字符串
     */
    public static String formPassToDBPass(String formPass, String salt) {
        String  str =
                "" + salt.charAt(1) + salt.charAt(4) + formPass + salt.charAt(2) + salt;
        return md5(str);
    }

    /**
     * 将表单输入的密码进行两次MD5加密
     * @param input 表单输入的密码字符串
     * @param saltDB 随机生成的salt字符串
     * @return 加密后的密码字符串
     */
    public static String inputPassToDBPass(String input, String saltDB) {
        String formPass = inputPassToFormPass(input);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }
}
