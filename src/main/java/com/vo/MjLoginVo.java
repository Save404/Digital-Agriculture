package com.vo;
import com.common.validator.IsMobile;
import org.hibernate.validator.constraints.NotEmpty;

public class MjLoginVo {

    @NotEmpty(message = "手机号不能为空")
    @IsMobile
    private String mjTelephone;

    @NotEmpty(message = "密码不能为空")
    private String mjPassword;

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

    @Override
    public String toString() {
        return "MjLoginVo{" +
                "mjTelephone='" + mjTelephone + '\'' +
                ", mjPassword='" + mjPassword + '\'' +
                '}';
    }
}
