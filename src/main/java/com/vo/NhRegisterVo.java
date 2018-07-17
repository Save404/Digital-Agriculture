package com.vo;

import com.util.validator.IsMobile;
import org.hibernate.validator.constraints.NotEmpty;

public class NhRegisterVo {

    @NotEmpty(message = "手机号不能为空")
    @IsMobile
    private String nhTelephone;

    @NotEmpty(message = "密码不能为空")
    private String nhPassword;

    @NotEmpty(message = "重复密码不能为空")
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
