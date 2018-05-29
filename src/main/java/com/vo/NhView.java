package com.vo;

import java.util.Date;

public class NhView {
    private String nhBasicId;
    private String nhTelephone;
    private Date nhRegisterDate;
    private Date nhLastLoginDate;
    private Long nhLoginCount;
    private String nhMoreId;
    private String nhRealName;
    private String nhIdCard;
    private String nhGhdwAddress;
    private String nhGhdwAreaCode;
    private String nhGhdwPhone;
    private Integer nhStatus;
    private String nhSex;
    private String nhOrigin;
    private String nhNation;
    private String nhPolitics;

    public String getNhBasicId() {
        return nhBasicId;
    }

    public void setNhBasicId(String nhBasicId) {
        this.nhBasicId = nhBasicId;
    }

    public String getNhTelephone() {
        return nhTelephone;
    }

    public void setNhTelephone(String nhTelephone) {
        this.nhTelephone = nhTelephone;
    }

    public Date getNhRegisterDate() {
        return nhRegisterDate;
    }

    public void setNhRegisterDate(Date nhRegisterDate) {
        this.nhRegisterDate = nhRegisterDate;
    }

    public Date getNhLastLoginDate() {
        return nhLastLoginDate;
    }

    public void setNhLastLoginDate(Date nhLastLoginDate) {
        this.nhLastLoginDate = nhLastLoginDate;
    }

    public Long getNhLoginCount() {
        return nhLoginCount;
    }

    public void setNhLoginCount(Long nhLoginCount) {
        this.nhLoginCount = nhLoginCount;
    }

    public String getNhMoreId() {
        return nhMoreId;
    }

    public void setNhMoreId(String nhMoreId) {
        this.nhMoreId = nhMoreId;
    }

    public String getNhRealName() {
        return nhRealName;
    }

    public void setNhRealName(String nhRealName) {
        this.nhRealName = nhRealName;
    }

    public String getNhIdCard() {
        return nhIdCard;
    }

    public void setNhIdCard(String nhIdCard) {
        this.nhIdCard = nhIdCard;
    }

    public String getNhGhdwAddress() {
        return nhGhdwAddress;
    }

    public void setNhGhdwAddress(String nhGhdwAddress) {
        this.nhGhdwAddress = nhGhdwAddress;
    }

    public String getNhGhdwAreaCode() {
        return nhGhdwAreaCode;
    }

    public void setNhGhdwAreaCode(String nhGndwAreaCode) {
        this.nhGhdwAreaCode = nhGndwAreaCode;
    }

    public String getNhGhdwPhone() {
        return nhGhdwPhone;
    }

    public void setNhGhdwPhone(String nhGhdwPhone) {
        this.nhGhdwPhone = nhGhdwPhone;
    }

    public Integer getNhStatus() {
        return nhStatus;
    }

    public void setNhStatus(Integer nhStatus) {
        this.nhStatus = nhStatus;
    }

    public String getNhSex() {
        return nhSex;
    }

    public void setNhSex(String nhSex) {
        this.nhSex = nhSex;
    }

    public String getNhOrigin() {
        return nhOrigin;
    }

    public void setNhOrigin(String nhOrigin) {
        this.nhOrigin = nhOrigin;
    }

    public String getNhNation() {
        return nhNation;
    }

    public void setNhNation(String nhNation) {
        this.nhNation = nhNation;
    }

    public String getNhPolitics() {
        return nhPolitics;
    }

    public void setNhPolitics(String nhPolitics) {
        this.nhPolitics = nhPolitics;
    }

    @Override
    public String toString() {
        return "NhView{" +
                "nhBasicId='" + nhBasicId + '\'' +
                ", nhTelephone='" + nhTelephone + '\'' +
                ", nhRegisterDate=" + nhRegisterDate +
                ", nhLastLoginDate=" + nhLastLoginDate +
                ", nhLoginCount=" + nhLoginCount +
                ", nhMoreId='" + nhMoreId + '\'' +
                ", nhRealName='" + nhRealName + '\'' +
                ", nhIdCard='" + nhIdCard + '\'' +
                ", nhGhdwAddress='" + nhGhdwAddress + '\'' +
                ", nhGhdwAreaCode='" + nhGhdwAreaCode + '\'' +
                ", nhGhdwPhone='" + nhGhdwPhone + '\'' +
                ", nhStatus=" + nhStatus +
                ", nhSex='" + nhSex + '\'' +
                ", nhOrigin='" + nhOrigin + '\'' +
                ", nhNation='" + nhNation + '\'' +
                ", nhPolitics='" + nhPolitics + '\'' +
                '}';
    }
}
