package com.domain;

import com.vo.NcpView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.util.Date;

@Data
@ApiModel(value = "合同实体")
public class Contract {

    /** 合同id */
    @ApiModelProperty(value = "合同id")
    private String contractId;

    /** 创建时间 */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /** 农户id */
    @ApiModelProperty(value = "农户id")
    @NotBlank(message = "农户信息异常")
    private String nhBasicId;

    /** 买家id */
    @ApiModelProperty(value = "买家id")
    @NotBlank(message = "买家信息异常")
    private String mjBasicId;

    /** 农产品id */
    @ApiModelProperty(value = "农产品id")
    @NotBlank(message = "产品信息异常")
    private String ncpBasicId;

    /** 购买方姓名 */
    @ApiModelProperty(value = "购买方姓名")
    @NotBlank(message = "购买方姓名不能为空")
    private String purchaserName;

    /** 销售方姓名 */
    @ApiModelProperty(value = "销售方姓名")
    private String salesName;

    /** 支付宝账号 */
    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;

    /** 购买数量 */
    @ApiModelProperty(value = "购买数量")
    @DecimalMin(value = "0", message = "购买数量不能为空")
    private BigDecimal purchaseQuantity;

    /** 单位 */
    @ApiModelProperty(value = "单位")
    @NotBlank(message = "单位不能为空")
    private String purchaseUnit;

    /** 总价 */
    @ApiModelProperty(value = "总价")
    private BigDecimal purchasePrice;

    /** 销售方违约金 */
    @ApiModelProperty(value = "销售方违约金")
    @DecimalMin(value = "0", message = "销售方违约金不能为空")
    private BigDecimal salesLiquidatedDamages;

    /** 购买方违约金 */
    @ApiModelProperty(value = "购买方违约金")
    private BigDecimal purchasesLiquidatedDamages;

    /** 状态 */
    @ApiModelProperty(value = "状态")
    private int statu;

    /** 收货地址 */
    @ApiModelProperty(value = "收获地址")
    @NotBlank(message = "收货地址不能为空")
    private String receivingAddress;

    /** 预付金 */
    @ApiModelProperty(value = "预付金")
    private BigDecimal prePayment;

    /** 支付状态 */
    @ApiModelProperty(value = "支付状态")

    private int payStatu;

    private NcpView ncpView;

    private String title;

    private String nhTelephone;

    private String mjTelephone;

}
