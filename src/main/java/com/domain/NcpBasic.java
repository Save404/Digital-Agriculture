package com.domain;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class NcpBasic {
    private String ncpBasicId;
    @NotEmpty(message = "农产品名不能为空")
    private String ncpName;
    private Date ncpPublishDate;
    @NotEmpty(message = "农产品种类不能为空")
    private String ncpPCode;
    @NotEmpty(message = "地区选项不能为空")
    private String ncpAreaCode;
    @NotEmpty(message = "详细地址不能为空")
    private String ncpAddress;
    private String nhBasicId;
    @NotEmpty(message = "产品特质不能为空")
    private String ncpFeature;
    private String ncpBrand;
    @DecimalMin(value = "0", message = "供应量不能为空")
    private BigDecimal ncpSupplyAmount;
    @NotEmpty(message = "年产量单位不能为空")
    private String supplyUnit;
    @DecimalMin(value = "0", message = "价格不能为空")
    private BigDecimal ncpPrice;
    @NotEmpty(message = "价格单位不能为空")
    private String priceUnit;
    private int ncpStatus;
}
