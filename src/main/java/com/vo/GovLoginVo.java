package com.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class GovLoginVo {

    @NotEmpty(message = "账号不能为空")
    private String govId;

    @NotEmpty(message = "密码不能为空")
    private String govPassword;


}
