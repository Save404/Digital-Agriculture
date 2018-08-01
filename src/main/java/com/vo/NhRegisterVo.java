package com.vo;

<<<<<<< HEAD
import com.common.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
=======
import com.util.validator.IsMobile;
import org.hibernate.validator.constraints.NotEmpty;

>>>>>>> origin/master
public class NhRegisterVo {

    @NotEmpty(message = "手机号不能为空")
    @IsMobile
    private String nhTelephone;

    @NotEmpty(message = "密码不能为空")
    private String nhPassword;

    @NotEmpty(message = "重复密码不能为空")
    private String rePassword;

}
