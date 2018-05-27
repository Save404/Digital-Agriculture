package com.exception;

import com.result.CodeMsg;

public class AgricultureException extends RuntimeException{

    private CodeMsg codeMsg;

    public AgricultureException(){
        super();
    }

    public AgricultureException(CodeMsg codeMsg){
        super();
        this.codeMsg = codeMsg;
    }

    public CodeMsg getCodeMsg() {
        return codeMsg;
    }

    public void setCodeMsg(CodeMsg codeMsg) {
        this.codeMsg = codeMsg;
    }
}
