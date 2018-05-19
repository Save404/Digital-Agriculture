package com.vo;

public class MjLoginVo {

    private String mjTelephone;

    private String mjPassword;

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

    @Override
    public String toString() {
        return "MjLoginVo{" +
                "mjTelephone='" + mjTelephone + '\'' +
                ", mjPassword='" + mjPassword + '\'' +
                '}';
    }
}
