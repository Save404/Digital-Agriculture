package com.vo;

import com.validator.IsMobile;

import javax.validation.constraints.NotNull;

public class NhRegisterVo {

    private String nhTelephone;

    private String nhPassword;

    private String rePassword;

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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    @Override
    public String toString() {
        return "NhRegisterVo{" +
                "nhTelephone='" + nhTelephone + '\'' +
                ", nhPassword='" + nhPassword + '\'' +
                ", rePassword='" + rePassword + '\'' +
                '}';
    }
}
