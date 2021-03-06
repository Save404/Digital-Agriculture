package com.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.common.validator.IsMobile;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

@Data
@ApiModel(value = "求购信息实体")
public class Purchases {

    @ApiModelProperty(value = "id")
    private String purchasesId;

    /** 用户Id */
    @ApiModelProperty(value = "用户id")
    @JsonIgnore
    @NotBlank(message = "用户信息异常")
    private String basicId;

    /** 标题 */
    @ApiModelProperty(value = "标题")
    @NotBlank(message = "标题不能为空")
    private String title;

    /** 内容 */
    @ApiModelProperty(value = "内容")
    @NotBlank(message = "内容不能为空")
    private String content;

    /** 联系电话 */
    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    @IsMobile(message = "手机号码格式错误")
    private String telephone;

    /** 发布时间 */
    @ApiModelProperty(value = "发布时间")
    private Date createDate;

    /** 重要程度 */
    @ApiModelProperty(value = "发布时间")
    private int level;

    /** 状态 */
    @ApiModelProperty(value = "状态")
    private int statu;

}
