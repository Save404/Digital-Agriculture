package com.vo;

import com.validator.IsMobile;
import org.hibernate.validator.constraints.NotEmpty;

public class MjRegisterVo {

    @NotEmpty(message = "手机号不能为空")
    @IsMobile
    private String mjTelephone;

    @NotEmpty(message = "密码不能为空")
    private String mjPassword;

    @NotEmpty(message = "重复密码不能为空")
    private String rePassword;

    public String getMjTelephone() {
        return mjTelephone;
    }

    public void setMjTelephone(String mjTelephone) {
        this.mjTelephone = mjTelephone;
    }

    public String getMjPassword() {
        return mjPassword;
    }

    public void setMjPassword(String mjPassword) {
        this.mjPassword = mjPassword;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    @Override
    public String toString() {
        return "MjRegisterVo{" +
                "mjTelephone='" + mjTelephone + '\'' +
                ", mjPassword='" + mjPassword + '\'' +
                ", rePassword='" + rePassword + '\'' +
                '}';
    }
}
