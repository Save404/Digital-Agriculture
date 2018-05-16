package com.domain;

import java.util.Date;

public class MjBasic {
    private String mjId;
    private String mjTelephone;
    private String mjPassword;
    private String mjSalt;
    private Date mjRegisterDate;
    private Date mjLastLoginDate;
    private Long mjLoginCount;

    public String getMjId() {
        return mjId;
    }

    public void setMjId(String mjId) {
        this.mjId = mjId;
    }

    public String getMjTelephone() {
        return mjTelephone;
    }

    public void setMjTelephone(String mjTelephone) {
        this.mjTelephone = mjTelephone;
    }

    public String getMjPassword() {
        return mjPassword;
    }

    public void setMjPassword(String mjPassword) {
        this.mjPassword = mjPassword;
    }

    public String getMjSalt() {
        return mjSalt;
    }

    public void setMjSalt(String mjSalt) {
        this.mjSalt = mjSalt;
    }

    public Date getMjRegisterDate() {
        return mjRegisterDate;
    }

    public void setMjRegisterDate(Date mjRegisterDate) {
        this.mjRegisterDate = mjRegisterDate;
    }

    public Date getMjLastLoginDate() {
        return mjLastLoginDate;
    }

    public void setMjLastLoginDate(Date mjLastLoginDate) {
        this.mjLastLoginDate = mjLastLoginDate;
    }

    public Long getMjLoginCount() {
        return mjLoginCount;
    }

    public void setMjLoginCount(Long mjLoginCount) {
        this.mjLoginCount = mjLoginCount;
    }

    @Override
    public String toString() {
        return "MjBasic{" +
                "mjId='" + mjId + '\'' +
                ", mjTelephone='" + mjTelephone + '\'' +
                ", mjPassword='" + mjPassword + '\'' +
                ", mjSalt='" + mjSalt + '\'' +
                ", mjRegisterDate=" + mjRegisterDate +
                ", mjLastLoginDate=" + mjLastLoginDate +
                ", mjLoginCount=" + mjLoginCount +
                '}';
    }
}
