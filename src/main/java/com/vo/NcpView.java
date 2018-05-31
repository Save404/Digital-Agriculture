package com.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class NcpView {
    private String ncpBasicId;
    private String ncpName;
    private Date ncpPublishDate;
    private String ncpPCode;
    private String ncpAreaCode;
    private String ncpAddress;
    @JsonIgnore
    private String nhBasicId;
    private String ncpFeature;
    private String ncpBrand;
    private String ncpAnnualOutput;
    private String ncpSupplyAmount;
    private String ncpReferencePrice;
    private String ncpMoreId;
    private String ncpDetail;
    private String ncpPackage;
    private String ncpQuality;
    private String ncpDeliveryInfo;
    private String ncpGrowthInfo;
    private String ncpGrowthSurrounding;
    private String ncpPlantArea;
    private String ncpBatchPrice;
    private Date ncpSupplyPeriodStart;
    private String ncpDeliveryAbility;
    private String ncpMinCount;
    private String ncpDeliveryCost;
    private Date ncpSupplyPeriodEnd;

    public String getNcpBasicId() {
        return ncpBasicId;
    }

    public void setNcpBasicId(String ncpBasicId) {
        this.ncpBasicId = ncpBasicId;
    }

    public String getNcpName() {
        return ncpName;
    }

    public void setNcpName(String ncpName) {
        this.ncpName = ncpName;
    }

    public Date getNcpPublishDate() {
        return ncpPublishDate;
    }

    public void setNcpPublishDate(Date ncpPublishDate) {
        this.ncpPublishDate = ncpPublishDate;
    }

    public String getNcpPCode() {
        return ncpPCode;
    }

    public void setNcpPCode(String ncpPCode) {
        this.ncpPCode = ncpPCode;
    }

    public String getNcpAreaCode() {
        return ncpAreaCode;
    }

    public void setNcpAreaCode(String ncpAreaCode) {
        this.ncpAreaCode = ncpAreaCode;
    }

    public String getNcpAddress() {
        return ncpAddress;
    }

    public void setNcpAddress(String ncpAddress) {
        this.ncpAddress = ncpAddress;
    }

    public String getNhBasicId() {
        return nhBasicId;
    }

    public void setNhBasicId(String nhBasicId) {
        this.nhBasicId = nhBasicId;
    }

    public String getNcpFeature() {
        return ncpFeature;
    }

    public void setNcpFeature(String ncpFeature) {
        this.ncpFeature = ncpFeature;
    }

    public String getNcpBrand() {
        return ncpBrand;
    }

    public void setNcpBrand(String ncpBrand) {
        this.ncpBrand = ncpBrand;
    }

    public String getNcpAnnualOutput() {
        return ncpAnnualOutput;
    }

    public void setNcpAnnualOutput(String ncpAnnualOutput) {
        this.ncpAnnualOutput = ncpAnnualOutput;
    }

    public String getNcpSupplyAmount() {
        return ncpSupplyAmount;
    }

    public void setNcpSupplyAmount(String ncpSupplyAmount) {
        this.ncpSupplyAmount = ncpSupplyAmount;
    }

    public String getNcpReferencePrice() {
        return ncpReferencePrice;
    }

    public void setNcpReferencePrice(String ncpReferencePrice) {
        this.ncpReferencePrice = ncpReferencePrice;
    }

    public String getNcpMoreId() {
        return ncpMoreId;
    }

    public void setNcpMoreId(String ncpMoreId) {
        this.ncpMoreId = ncpMoreId;
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

    public String getNcpPlantArea() {
        return ncpPlantArea;
    }

    public void setNcpPlantArea(String ncpPlantArea) {
        this.ncpPlantArea = ncpPlantArea;
    }

    public String getNcpBatchPrice() {
        return ncpBatchPrice;
    }

    public void setNcpBatchPrice(String ncpBatchPrice) {
        this.ncpBatchPrice = ncpBatchPrice;
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

    public String getNcpMinCount() {
        return ncpMinCount;
    }

    public void setNcpMinCount(String ncpMinCount) {
        this.ncpMinCount = ncpMinCount;
    }

    public String getNcpDeliveryCost() {
        return ncpDeliveryCost;
    }

    public void setNcpDeliveryCost(String ncpDeliveryCost) {
        this.ncpDeliveryCost = ncpDeliveryCost;
    }

    public Date getNcpSupplyPeriodEnd() {
        return ncpSupplyPeriodEnd;
    }

    public void setNcpSupplyPeriodEnd(Date ncpSupplyPeriodEnd) {
        this.ncpSupplyPeriodEnd = ncpSupplyPeriodEnd;
    }

    @Override
    public String toString() {
        return "NcpView{" +
                "ncpBasicId='" + ncpBasicId + '\'' +
                ", ncpName='" + ncpName + '\'' +
                ", ncpPublishDate=" + ncpPublishDate +
                ", ncpPCode='" + ncpPCode + '\'' +
                ", ncpAreaCode='" + ncpAreaCode + '\'' +
                ", ncpAddress='" + ncpAddress + '\'' +
                ", nhBasicId='" + nhBasicId + '\'' +
                ", ncpFeature='" + ncpFeature + '\'' +
                ", ncpBrand='" + ncpBrand + '\'' +
                ", ncpAnnualOutput='" + ncpAnnualOutput + '\'' +
                ", ncpSupplyAmount='" + ncpSupplyAmount + '\'' +
                ", ncpReferencePrice='" + ncpReferencePrice + '\'' +
                ", ncpMoreId='" + ncpMoreId + '\'' +
                ", ncpDetail='" + ncpDetail + '\'' +
                ", ncpPackage='" + ncpPackage + '\'' +
                ", ncpQuality='" + ncpQuality + '\'' +
                ", ncpDeliveryInfo='" + ncpDeliveryInfo + '\'' +
                ", ncpGrowthInfo='" + ncpGrowthInfo + '\'' +
                ", ncpGrowthSurrounding='" + ncpGrowthSurrounding + '\'' +
                ", ncpPlantArea='" + ncpPlantArea + '\'' +
                ", ncpBatchPrice='" + ncpBatchPrice + '\'' +
                ", ncpSupplyPeriodStart=" + ncpSupplyPeriodStart +
                ", ncpDeliveryAbility='" + ncpDeliveryAbility + '\'' +
                ", ncpMinCount='" + ncpMinCount + '\'' +
                ", ncpDeliveryCost='" + ncpDeliveryCost + '\'' +
                ", ncpSupplyPeriodEnd=" + ncpSupplyPeriodEnd +
                '}';
    }
}
