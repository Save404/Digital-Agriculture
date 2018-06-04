package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NhMoreDto {
    private String nhRealName;
    private String nhSex;
    private String nameA;
    private String nameC;
    private String nameP;
    private String nhOrigin;
    private String nhNation;
    private String nhPolitics;
    private String nhIdCard;
    private String nhGhdwAddress;
    private String nhGhdwPhone;
    private String nhPayPassword;
    @JsonIgnore
    private String nhPaySalt;

    public String getNhPaySalt() {
        return nhPaySalt;
    }

    public void setNhPaySalt(String nhPaySalt) {
        this.nhPaySalt = nhPaySalt;
    }

    public String getNhRealName() {
        return nhRealName;
    }

    public void setNhRealName(String nhRealName) {
        this.nhRealName = nhRealName;
    }

    public String getNhSex() {
        return nhSex;
    }

    public void setNhSex(String nhSex) {
        this.nhSex = nhSex;
    }

    public String getNameA() {
        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }

    public String getNameC() {
        return nameC;
    }

    public void setNameC(String nameC) {
        this.nameC = nameC;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
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

    public String getNhGhdwPhone() {
        return nhGhdwPhone;
    }

    public void setNhGhdwPhone(String nhGhdwPhone) {
        this.nhGhdwPhone = nhGhdwPhone;
    }

    public String getNhPayPassword() {
        return nhPayPassword;
    }

    public void setNhPayPassword(String nhPayPassword) {
        this.nhPayPassword = nhPayPassword;
    }

    @Override
    public String toString() {
        return "NhMoreDto{" +
                "nhRealName='" + nhRealName + '\'' +
                ", nhSex='" + nhSex + '\'' +
                ", nameA='" + nameA + '\'' +
                ", nameC='" + nameC + '\'' +
                ", nameP='" + nameP + '\'' +
                ", nhOrigin='" + nhOrigin + '\'' +
                ", nhNation='" + nhNation + '\'' +
                ", nhPolitics='" + nhPolitics + '\'' +
                ", nhIdCard='" + nhIdCard + '\'' +
                ", nhGhdwAddress='" + nhGhdwAddress + '\'' +
                ", nhGhdwPhone='" + nhGhdwPhone + '\'' +
                ", nhPayPassword='" + nhPayPassword + '\'' +
                ", nhPaySalt='" + nhPaySalt + '\'' +
                '}';
    }
}
