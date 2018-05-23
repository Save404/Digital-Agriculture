package com.result;

public class CodeMsg {

    private int code;
    private String msg;

    //成功代码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    //通用的错误码
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    public static CodeMsg BIND_ERROR = new CodeMsg(500101, "参数校验异常：%s");
    public static CodeMsg LOGIN_ERROR = new CodeMsg(500102, "尚未登录");
    //注册登录模块 5002XX
    public static CodeMsg TELEPHONE_EMPTY = new CodeMsg(500200, "手机号不能为空");
    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500201, "密码不能为空");
    public static CodeMsg TELEPHONE_ERROR = new CodeMsg(500202, "手机号格式错误");
    public static CodeMsg TELEPHONE_REPEAT = new CodeMsg(500203, "手机号已被注册");
    public static CodeMsg REPASSWORD_ERROR = new CodeMsg(500204, "两次密码不一致");
    public static CodeMsg NH_NOT_EXISTS = new CodeMsg(500205, "该用户不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500206, "密码错误");
    //农户信息完善模块 5003XX
    public static CodeMsg NAME_EMPTY = new CodeMsg(500300, "姓名不能为空");
    public static CodeMsg ID_CARD_EMPTY = new CodeMsg(500301, "身份证不能为空");
    public static CodeMsg ID_CARD_ERROR = new CodeMsg(500301, "身份证格式错误");
    public static CodeMsg GHDW_Area_Code = new CodeMsg(500302, "供货单位地址不能为空");
    public static CodeMsg SEX_EMPTY = new CodeMsg(500303, "性别不能为空");
    public static CodeMsg ORIGIN_EMPTY = new CodeMsg(500304, "籍贯不能为空");
    public static CodeMsg NATION_EMPTY = new CodeMsg(500305, "民族不能为空");
    //买家信息完善模块 5004XX

    private CodeMsg() {
    }

    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public CodeMsg fillArgs(Object... args) {
        int code = this.code;
        String message = String.format(this.msg, args);
        return new CodeMsg(code, message);
    }
    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }
}