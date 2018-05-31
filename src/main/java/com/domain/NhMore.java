package com.domain;

import com.validator.IsIdCard;
import org.hibernate.validator.constraints.NotEmpty;

public class NhMore {
    private String nhMoreId;
    private String nhBasicId;
    @NotEmpty(message = "真实姓名不能为空")
    private String nhRealName;
    @NotEmpty(message = "身份证不能为空")
    @IsIdCard
    private String nhIdCard;
    private String nhGhdwAddress;
    @NotEmpty(message = "供货单位地区选项错误")
    private String nhGhdwAreaCode;
    private String nhGhdwPhone;
    private String nhPayPassword;
    private String nhPaySalt;
    private int nhStatus;
    @NotEmpty(message = "性别不能为空")
    private String nhSex;
    @NotEmpty(message = "籍贯不能为空")
    private String nhOrigin;
    @NotEmpty(message = "民族不能为空")
    private String nhNation;
    private String nhPolitics;

    public String getNhMoreId() {
        return nhMoreId;
    }

    public void setNhMoreId(String nhMoreId) {
        this.nhMoreId = nhMoreId;
    }

    public String getNhBasicId() {
        return nhBasicId;
    }

    public void setNhBasicId(String nhBasicId) {
        this.nhBasicId = nhBasicId;
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

    public void setNhGhdwAreaCode(String nhGhdwAreaCode) {
        this.nhGhdwAreaCode = nhGhdwAreaCode;
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

    public String getNhPaySalt() {
        return nhPaySalt;
    }

    public void setNhPaySalt(String nhPaySalt) {
        this.nhPaySalt = nhPaySalt;
    }

    public int getNhStatus() {
        return nhStatus;
    }

    public void setNhStatus(int nhStatus) {
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
        return "NhMore{" +
                "nhMoreId='" + nhMoreId + '\'' +
                ", nhBasicId='" + nhBasicId + '\'' +
                ", nhRealName='" + nhRealName + '\'' +
                ", nhIdCard='" + nhIdCard + '\'' +
                ", nhGhdwAddress='" + nhGhdwAddress + '\'' +
                ", nhGhdwAreaCode='" + nhGhdwAreaCode + '\'' +
                ", nhGhdwPhone='" + nhGhdwPhone + '\'' +
                ", nhPayPassword='" + nhPayPassword + '\'' +
                ", nhPaySalt='" + nhPaySalt + '\'' +
                ", nhStatus=" + nhStatus +
                ", nhSex='" + nhSex + '\'' +
                ", nhOrigin='" + nhOrigin + '\'' +
                ", nhNation='" + nhNation + '\'' +
                ", nhPolitics='" + nhPolitics + '\'' +
                '}';
    }
}
