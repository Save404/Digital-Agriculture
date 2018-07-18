package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.util.validator.IsMobile;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
public class Purchases {
    private String purchasesId;

    /** 用户Id */
    @JsonIgnore
    private String basicId;

    /** 标题 */
    @NotBlank(message = "标题不能为空")
    private String title;

    /** 内容 */
    @NotBlank(message = "内容不能为空")
    private String content;

    /** 联系电话 */
    @NotBlank(message = "手机号码不能为空")
    @IsMobile(message = "手机号码格式错误")
    private String telephone;

    /** 发布时间 */
    private Date createDate;

    /** 重要程度 */
    private int level;
}
