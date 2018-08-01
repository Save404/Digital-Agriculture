package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import com.common.validator.IsIdCard;
=======
import com.util.validator.IsIdCard;
>>>>>>> origin/master
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class NhMore {
    private String nhMoreId;
    private String nhBasicId;
    @NotEmpty(message = "真实姓名不能为空")
    private String nhRealName;
    @NotEmpty(message = "身份证不能为空")
    @IsIdCard
    private String nhIdCard;
    @NotEmpty(message = "供货单位地址不能为空")
    private String nhGhdwAddress;
    @NotEmpty(message = "供货单位地区选项错误")
    private String nhGhdwAreaCode;
    @NotEmpty(message = "供货单位联系方式不能为空")
    private String nhGhdwPhone;
    @JsonIgnore
    private String nhPayPassword;
    @JsonIgnore
    private String nhPaySalt;
    private int nhStatus;
    @NotEmpty(message = "性别不能为空")
    private String nhSex;
    @NotEmpty(message = "籍贯不能为空")
    private String nhOrigin;
    @NotEmpty(message = "民族不能为空")
    private String nhNation;
    @NotEmpty(message = "政治面貌不能为空")
    private String nhPolitics;

}
