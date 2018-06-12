package com.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NcpMore {
    private String ncpMoreId;
    private String ncpBasicId;
    private String ncpDetail;
    private String ncpPackage;
    private String ncpQuality;
    private String ncpDeliveryInfo;
    private String ncpGrowthInfo;
    private String ncpGrowthSurrounding;
    private BigDecimal ncpPlantArea;
    private Date ncpSupplyPeriodStart;
    private String ncpDeliveryAbility;
    private Date ncpSupplyPeriodEnd;
    private String plantUnit;
    private String ncpImg;
}
