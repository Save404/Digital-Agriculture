package com.domain;

import com.validator.IsIdCard;
import org.hibernate.validator.constraints.NotEmpty;

public class MjMore {
    private String mjMoreId;
    private String mjBasicId;
    @NotEmpty(message = "姓名不能为空")
    private String mjRealName;
    @NotEmpty(message = "身份证不能为空")
    @IsIdCard
    private String mjIdCard;
    @NotEmpty(message = "性别不能为空")
    private String mjSex;
    @NotEmpty(message = "支付密码不能为空")
    private String mjPayPassword;
    private String mjPaySalt;
    @NotEmpty(message = "地区选项不能为空")
    private String mjACode;
    private int mjStatus;
    @NotEmpty(message = "籍贯不能为空")
    private String mjOrigin;
    @NotEmpty(message = "民族不能为空")
    private String mjNation;
    @NotEmpty(message = "政治面貌不能为空")
    private String mjPolitics;

    public String getMjMoreId() {
        return mjMoreId;
    }

    public void setMjMoreId(String mjMoreId) {
        this.mjMoreId = mjMoreId;
    }

    public String getMjBasicId() {
        return mjBasicId;
    }

    public void setMjBasicId(String mjBasicId) {
        this.mjBasicId = mjBasicId;
    }

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

    public String getMjACode() {
        return mjACode;
    }

    public void setMjACode(String mjACode) {
        this.mjACode = mjACode;
    }

    public int getMjStatus() {
        return mjStatus;
    }

    public void setMjStatus(int mjStatus) {
        this.mjStatus = mjStatus;
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

    @Override
    public String toString() {
        return "MjMore{" +
                "mjMoreId='" + mjMoreId + '\'' +
                ", mjBasicId='" + mjBasicId + '\'' +
                ", mjRealName='" + mjRealName + '\'' +
                ", mjIdCard='" + mjIdCard + '\'' +
                ", mjSex='" + mjSex + '\'' +
                ", mjPayPassword='" + mjPayPassword + '\'' +
                ", mjPaySalt='" + mjPaySalt + '\'' +
                ", mjACode='" + mjACode + '\'' +
                ", mjStatus=" + mjStatus +
                ", mjOrigin='" + mjOrigin + '\'' +
                ", mjNation='" + mjNation + '\'' +
                ", mjPolitics='" + mjPolitics + '\'' +
                '}';
    }
}
