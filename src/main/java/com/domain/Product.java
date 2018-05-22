package com.domain;

public class Product {
    private Long pId;
    private String pCode;
    private String pName;
    private String fCode;

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getfCode() {
        return fCode;
    }

    public void setfCode(String fCode) {
        this.fCode = fCode;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pId=" + pId +
                ", pCode='" + pCode + '\'' +
                ", pName='" + pName + '\'' +
                ", fCode='" + fCode + '\'' +
                '}';
    }
}
