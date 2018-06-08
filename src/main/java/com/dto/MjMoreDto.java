package com.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MjMoreDto {
    private String mjRealName;
    private String mjIdCard;
    private String mjSex;
    private String mjPayPassword;
    @JsonIgnore
    private String mjPaySalt;
    private String mjOrigin;
    private String mjNation;
    private String mjPolitics;
    private String nameA;
    private String nameC;
    private String nameP;
    private String mjACode;

    public String getMjRealName() {
        return mjRealName;
    }

    public void setMjRealName(String mjRealName) {
        this.mjRealName = mjRealName;
    }

    public String getMjIdCard() {
        return mjIdCard;
    }

    public void setMjIdCard(String mjIdCard) {
        this.mjIdCard = mjIdCard;
    }

    public String getMjSex() {
        return mjSex;
    }

    public void setMjSex(String mjSex) {
        this.mjSex = mjSex;
    }

    public String getMjPayPassword() {
        return mjPayPassword;
    }

    public void setMjPayPassword(String mjPayPassword) {
        this.mjPayPassword = mjPayPassword;
    }

    public String getMjPaySalt() {
        return mjPaySalt;
    }

    public void setMjPaySalt(String mjPaySalt) {
        this.mjPaySalt = mjPaySalt;
    }

    public String getMjOrigin() {
        return mjOrigin;
    }

    public void setMjOrigin(String mjOrigin) {
        this.mjOrigin = mjOrigin;
    }

    public String getMjNation() {
        return mjNation;
    }

    public void setMjNation(String mjNation) {
        this.mjNation = mjNation;
    }

    public String getMjPolitics() {
        return mjPolitics;
    }

    public void setMjPolitics(String mjPolitics) {
        this.mjPolitics = mjPolitics;
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

    public String getMjACode() {
        return mjACode;
    }

    public void setMjACode(String mjACode) {
        this.mjACode = mjACode;
    }
}
