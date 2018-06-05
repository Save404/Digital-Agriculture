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

}
