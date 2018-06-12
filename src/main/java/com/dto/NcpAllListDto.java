package com.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NcpAllListDto {
    private String ncpBasicId;
    private String ncpName;
    private Date ncpPublishDate;
    private String c1Name;
    private String c2Name;
    private String c3Name;
    private String nameP;
    private String nameC;
    private String nameA;
    private String ncpAddress;
    private String ncpFeature;
    private String ncpBrand;
    private BigDecimal ncpSupplyAmount;
    private String supplyUnit;
    private BigDecimal ncpPrice;
    private String priceUnit;
    private int ncpStatus;
    private String ncpDetail;
    private String ncpPackage;
    private String ncpQuality;
    private String ncpDeliveryInfo;
    private String ncpGrowthInfo;
    private String ncpGrowthSurrounding;
    private Date ncpSupplyPeriodStart;
    private Date ncpSupplyPeriodEnd;
    private String ncpImg;
    private BigDecimal ncpPlantArea;
    private String plantUnit;
    private String nhBasicId;
}
