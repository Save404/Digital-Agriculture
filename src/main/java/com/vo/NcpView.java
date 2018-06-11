package com.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
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
    private BigDecimal ncpSupplyAmount;
    private String supplyUnit;
    @JsonIgnore
    private String ncpMoreId;
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
    private String nameC;
    private String nameA;
    private String nameP;
    private BigDecimal ncpPrice;
    private String priceUnit;
    private int ncpStatus;
    private String ncpImg;

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

    public BigDecimal getNcpSupplyAmount() {
        return ncpSupplyAmount;
    }

    public void setNcpSupplyAmount(BigDecimal ncpSupplyAmount) {
        this.ncpSupplyAmount = ncpSupplyAmount;
    }

    public String getSupplyUnit() {
        return supplyUnit;
    }

    public void setSupplyUnit(String supplyUnit) {
        this.supplyUnit = supplyUnit;
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

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public BigDecimal getNcpPrice() {
        return ncpPrice;
    }

    public void setNcpPrice(BigDecimal ncpPrice) {
        this.ncpPrice = ncpPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getNcpStatus() {
        return ncpStatus;
    }

    public void setNcpStatus(int ncpStatus) {
        this.ncpStatus = ncpStatus;
    }

    public String getNcpImg() {
        return ncpImg;
    }

    public void setNcpImg(String ncpImg) {
        this.ncpImg = ncpImg;
    }
}
