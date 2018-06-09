package com.domain;

import java.math.BigDecimal;
import java.util.Date;

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

    public String getNcpMoreId() {
        return ncpMoreId;
    }

    public void setNcpMoreId(String ncpMoreId) {
        this.ncpMoreId = ncpMoreId;
    }

    public String getNcpBasicId() {
        return ncpBasicId;
    }

    public void setNcpBasicId(String ncpBasicId) {
        this.ncpBasicId = ncpBasicId;
    }

    public String getNcpDetail() {
        return ncpDetail;
    }

    public void setNcpDetail(String ncpDetail) {
        this.ncpDetail = ncpDetail;
    }

    public String getNcpPackage() {
        return ncpPackage;
    }

    public void setNcpPackage(String ncpPackage) {
        this.ncpPackage = ncpPackage;
    }

    public String getNcpQuality() {
        return ncpQuality;
    }

    public void setNcpQuality(String ncpQuality) {
        this.ncpQuality = ncpQuality;
    }

    public String getNcpDeliveryInfo() {
        return ncpDeliveryInfo;
    }

    public void setNcpDeliveryInfo(String ncpDeliveryInfo) {
        this.ncpDeliveryInfo = ncpDeliveryInfo;
    }

    public String getNcpGrowthInfo() {
        return ncpGrowthInfo;
    }

    public void setNcpGrowthInfo(String ncpGrowthInfo) {
        this.ncpGrowthInfo = ncpGrowthInfo;
    }

    public String getNcpGrowthSurrounding() {
        return ncpGrowthSurrounding;
    }

    public void setNcpGrowthSurrounding(String ncpGrowthSurrounding) {
        this.ncpGrowthSurrounding = ncpGrowthSurrounding;
    }

    public BigDecimal getNcpPlantArea() {
        return ncpPlantArea;
    }

    public void setNcpPlantArea(BigDecimal ncpPlantArea) {
        this.ncpPlantArea = ncpPlantArea;
    }

    public Date getNcpSupplyPeriodStart() {
        return ncpSupplyPeriodStart;
    }

    public void setNcpSupplyPeriodStart(Date ncpSupplyPeriodStart) {
        this.ncpSupplyPeriodStart = ncpSupplyPeriodStart;
    }

    public String getNcpDeliveryAbility() {
        return ncpDeliveryAbility;
    }

    public void setNcpDeliveryAbility(String ncpDeliveryAbility) {
        this.ncpDeliveryAbility = ncpDeliveryAbility;
    }

    public Date getNcpSupplyPeriodEnd() {
        return ncpSupplyPeriodEnd;
    }

    public void setNcpSupplyPeriodEnd(Date ncpSupplyPeriodEnd) {
        this.ncpSupplyPeriodEnd = ncpSupplyPeriodEnd;
    }

    public String getPlantUnit() {
        return plantUnit;
    }

    public void setPlantUnit(String plantUnit) {
        this.plantUnit = plantUnit;
    }

    public String getNcpImg() {
        return ncpImg;
    }

    public void setNcpImg(String ncpImg) {
        this.ncpImg = ncpImg;
    }

    @Override
    public String toString() {
        return "NcpMore{" +
                "ncpMoreId='" + ncpMoreId + '\'' +
                ", ncpBasicId='" + ncpBasicId + '\'' +
                ", ncpDetail='" + ncpDetail + '\'' +
                ", ncpPackage='" + ncpPackage + '\'' +
                ", ncpQuality='" + ncpQuality + '\'' +
                ", ncpDeliveryInfo='" + ncpDeliveryInfo + '\'' +
                ", ncpGrowthInfo='" + ncpGrowthInfo + '\'' +
                ", ncpGrowthSurrounding='" + ncpGrowthSurrounding + '\'' +
                ", ncpPlantArea=" + ncpPlantArea +
                ", ncpSupplyPeriodStart=" + ncpSupplyPeriodStart +
                ", ncpDeliveryAbility='" + ncpDeliveryAbility + '\'' +
                ", ncpSupplyPeriodEnd=" + ncpSupplyPeriodEnd +
                ", plantUnit='" + plantUnit + '\'' +
                ", ncpImg='" + ncpImg + '\'' +
                '}';
    }
}
