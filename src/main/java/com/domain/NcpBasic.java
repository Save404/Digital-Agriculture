package com.domain;

import java.util.Date;

public class NcpBasic {
    private String ncpBasicId;
    private String ncpName;
    private Date ncpPublishDate;
    private String ncpPCode;
    private String ncpAreaCode;
    private String ncpAddress;
    private String nhBasicId;
    private String ncpFeature;
    private String ncpBrand;
    private String ncpAnnualOutput;
    private String ncpSupplyAmount;
    private String ncpReferencePrice;

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

    @Override
    public String toString() {
        return "NcpBasic{" +
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
                '}';
    }
}
