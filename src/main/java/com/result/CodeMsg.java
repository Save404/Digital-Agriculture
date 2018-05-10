package com.result;

public class CodeMsg {

    private int code;
    private String msg;

    //成功代码
    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    //通用的错误码
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "服务端异常");
    //登录模块 5002XX

    //商品模块 5003XX

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
    @Override
    public String toString() {
        return "CodeMsg [code=" + code + ", msg=" + msg + "]";
    }
}