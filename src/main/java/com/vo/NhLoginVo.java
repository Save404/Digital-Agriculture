package com.vo;

import com.validator.IsMobile;
import javax.validation.constraints.NotNull;

public class NhLoginVo {

    private String nhTelephone;

    private String nhPassword;

    public String getNhTelephone() {
        return nhTelephone;
    }

    public void setNhTelephone(String nhTelephone) {
        this.nhTelephone = nhTelephone;
    }

    public String getNhPassword() {
        return nhPassword;
    }

    public void setNhPassword(String nhPassword) {
        this.nhPassword = nhPassword;
    }

    @Override
    public String toString() {
        return "NhLoginVo{" +
                "nhTelephone='" + nhTelephone + '\'' +
                ", nhPassword='" + nhPassword + '\'' +
                '}';
    }
}
