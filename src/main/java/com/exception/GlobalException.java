package com.exception;

import com.result.CodeMsg;

public class GlobalException extends RuntimeException {
    private CodeMsg msg;

    public CodeMsg getMsg() {
        return msg;
    }

    public GlobalException(CodeMsg msg) {
        super(msg.toString());
        this.msg = msg;
    }
}
