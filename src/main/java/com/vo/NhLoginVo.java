package com.vo;

<<<<<<< HEAD
import com.common.validator.IsMobile;
=======
import com.util.validator.IsMobile;
>>>>>>> origin/master
import org.hibernate.validator.constraints.NotEmpty;

public class NhLoginVo {

    @NotEmpty(message = "手机号不能为空")
    @IsMobile
    private String nhTelephone;

    @NotEmpty(message = "密码不能为空")
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
