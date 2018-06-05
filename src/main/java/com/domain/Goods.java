package com.domain;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;

public class Goods {
    private String goodId;
    @NotEmpty(message = "产品名字不能为空")
    private String goodName;
    private Date goodPublishDate;
    @NotEmpty(message = "产品种类不能为空")
    private String goodPCode;
    @NotEmpty(message = "地区选项不能为空")
    private String goodAreaCode;
    private String nhBasicId;
    @NotEmpty(message = "产品特质不能为空")
    private String goodFeature;
    private String goodBrand;
    @NotEmpty
    private Double goodSupplyAmount;
    @NotEmpty
    private String supplyUnit;
    @NotEmpty
    private Double goodPrice;
    @NotEmpty
    private String priceUnit;
    private String goodDetail;
    private String goodPackage;
    private String goodQuality;
    private String goodDeliveryInfo;
    private String goodGrowthInfo;
    private String goodGrowthSurrounding;
    private String goodMore;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Date getGoodPublishDate() {
        return goodPublishDate;
    }

    public void setGoodPublishDate(Date goodPublishDate) {
        this.goodPublishDate = goodPublishDate;
    }

    public String getGoodPCode() {
        return goodPCode;
    }

    public void setGoodPCode(String goodPCode) {
        this.goodPCode = goodPCode;
    }

    public String getGoodAreaCode() {
        return goodAreaCode;
    }

    public void setGoodAreaCode(String goodAreaCode) {
        this.goodAreaCode = goodAreaCode;
    }

    public String getNhBasicId() {
        return nhBasicId;
    }

    public void setNhBasicId(String nhBasicId) {
        this.nhBasicId = nhBasicId;
    }

    public String getGoodFeature() {
        return goodFeature;
    }

    public void setGoodFeature(String goodFeature) {
        this.goodFeature = goodFeature;
    }

    public String getGoodBrand() {
        return goodBrand;
    }

    public void setGoodBrand(String goodBrand) {
        this.goodBrand = goodBrand;
    }

    public Double getGoodSupplyAmount() {
        return goodSupplyAmount;
    }

    public void setGoodSupplyAmount(Double goodSupplyAmount) {
        this.goodSupplyAmount = goodSupplyAmount;
    }

    public String getSupplyUnit() {
        return supplyUnit;
    }

    public void setSupplyUnit(String supplyUnit) {
        this.supplyUnit = supplyUnit;
    }

    public Double getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Double goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getGoodDetail() {
        return goodDetail;
    }

    public void setGoodDetail(String goodDetail) {
        this.goodDetail = goodDetail;
    }

    public String getGoodPackage() {
        return goodPackage;
    }

    public void setGoodPackage(String goodPackage) {
        this.goodPackage = goodPackage;
    }

    public String getGoodQuality() {
        return goodQuality;
    }

    public void setGoodQuality(String goodQuality) {
        this.goodQuality = goodQuality;
    }

    public String getGoodDeliveryInfo() {
        return goodDeliveryInfo;
    }

    public void setGoodDeliveryInfo(String goodDeliveryInfo) {
        this.goodDeliveryInfo = goodDeliveryInfo;
    }

    public String getGoodGrowthInfo() {
        return goodGrowthInfo;
    }

    public void setGoodGrowthInfo(String goodGrowthInfo) {
        this.goodGrowthInfo = goodGrowthInfo;
    }

    public String getGoodGrowthSurrounding() {
        return goodGrowthSurrounding;
    }

    public void setGoodGrowthSurrounding(String goodGrowthSurrounding) {
        this.goodGrowthSurrounding = goodGrowthSurrounding;
    }

    public String getGoodMore() {
        return goodMore;
    }

    public void setGoodMore(String goodMore) {
        this.goodMore = goodMore;
    }
}
