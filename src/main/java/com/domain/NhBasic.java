package com.domain;

import java.util.Date;

public class NhBasic {
    private String nhBasicId;
    private String nhTelephone;
    private String nhPassword;
    private String nhSalt;
    private Date nhRegisterDate;
    private Date nhLastLoginDate;
    private Long nhLoginCount;

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

    public String getNhPassword() {
        return nhPassword;
    }

    public void setNhPassword(String nhPassword) {
        this.nhPassword = nhPassword;
    }

    public String getNhSalt() {
        return nhSalt;
    }

    public void setNhSalt(String nhSalt) {
        this.nhSalt = nhSalt;
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

    @Override
    public String toString() {
        return "NhBasic{" +
                "nhBasicId='" + nhBasicId + '\'' +
                ", nhTelephone='" + nhTelephone + '\'' +
                ", nhPassword='" + nhPassword + '\'' +
                ", nhSalt='" + nhSalt + '\'' +
                ", nhRegisterDate=" + nhRegisterDate +
                ", nhLastLoginDate=" + nhLastLoginDate +
                ", nhLoginCount=" + nhLoginCount +
                '}';
    }
}
