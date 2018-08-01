package com.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class NcpView {
    private String ncpBasicId;
    private String ncpName;
    private Date ncpPublishDate;
    private String ncpPCode;
    private String ncpAreaCode;
    private String ncpAddress;
    private String ncpFeature;
    private String ncpBrand;
    private BigDecimal ncpSupplyAmount;
    private String supplyUnit;
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
    private BigDecimal ncpPrice;
    private String priceUnit;
    private int ncpStatus;
    private String ncpImg;
    private PCAView pcaView;
    private CPView cpView;
}
