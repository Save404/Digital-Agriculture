package com.domain;

import java.util.Date;

public class NcpBasic {
    private String ncpId;
    private String ncpName;
    private Date ncpPublishDate;
    private String pCode;
    private String ncpAreaCode;
    private String ncpAddress;
    private String nhId;
    private String ncpFeature;
    private String ncpBrand;
    private String ncpAnnualOutput;
    private String ncpSupplyAmount;
    private String ncpReferencePrice;

    public String getNcpId() {
        return ncpId;
    }

    public void setNcpId(String ncpId) {
        this.ncpId = ncpId;
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

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
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

    public String getNhId() {
        return nhId;
    }

    public void setNhId(String nhId) {
        this.nhId = nhId;
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

    @Override
    public String toString() {
        return "NcpBasic{" +
                "ncpId='" + ncpId + '\'' +
                ", ncpName='" + ncpName + '\'' +
                ", ncpPublishDate=" + ncpPublishDate +
                ", pCode='" + pCode + '\'' +
                ", ncpAreaCode='" + ncpAreaCode + '\'' +
                ", ncpAddress='" + ncpAddress + '\'' +
                ", nhId='" + nhId + '\'' +
                ", ncpFeature='" + ncpFeature + '\'' +
                ", ncpBrand='" + ncpBrand + '\'' +
                ", ncpAnnualOutput='" + ncpAnnualOutput + '\'' +
                ", ncpSupplyAmount='" + ncpSupplyAmount + '\'' +
                ", ncpReferencePrice='" + ncpReferencePrice + '\'' +
                '}';
    }
}
