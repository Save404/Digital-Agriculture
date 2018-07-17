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
    public static CodeMsg DB_ERROR = new CodeMsg(500102, "数据库异常");
    //注册登录模块 5002XX
    public static CodeMsg TELEPHONE_REPEAT = new CodeMsg(500203, "手机号已被注册");
    public static CodeMsg REPASSWORD_ERROR = new CodeMsg(500204, "两次密码不一致");
    public static CodeMsg NH_NOT_EXISTS = new CodeMsg(500205, "该用户不存在");
    public static CodeMsg PASSWORD_ERROR = new CodeMsg(500206, "密码错误");
    //农户信息完善模块 5003XX
    //买家信息完善模块 5004XX
    //农产品信息记录模块 5005XX
    public static CodeMsg NCP_SUPPLY_PERIOD_ERROR = new CodeMsg(500505, "农产品供应时间错误");

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