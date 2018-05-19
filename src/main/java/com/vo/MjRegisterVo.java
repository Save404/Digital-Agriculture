package com.vo;

public class MjRegisterVo {
    private String mjTelephone;

    private String mjPassword;

    private String rePassword;

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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    @Override
    public String toString() {
        return "MjRegisterVo{" +
                "mjTelephone='" + mjTelephone + '\'' +
                ", mjPassword='" + mjPassword + '\'' +
                ", rePassword='" + rePassword + '\'' +
                '}';
    }
}
