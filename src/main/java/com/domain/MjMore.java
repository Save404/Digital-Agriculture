package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.util.validator.IsIdCard;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class MjMore {
    private String mjMoreId;
    private String mjBasicId;
    @NotEmpty(message = "姓名不能为空")
    private String mjRealName;
    @NotEmpty(message = "身份证不能为空")
    @IsIdCard
    private String mjIdCard;
    @NotEmpty(message = "性别不能为空")
    private String mjSex;
    @JsonIgnore
    private String mjPayPassword;
    @JsonIgnore
    private String mjPaySalt;
    @NotEmpty(message = "地区选项不能为空")
    private String mjACode;
    private int mjStatus;
    @NotEmpty(message = "籍贯不能为空")
    private String mjOrigin;
    @NotEmpty(message = "民族不能为空")
    private String mjNation;
    @NotEmpty(message = "政治面貌不能为空")
    private String mjPolitics;
}
