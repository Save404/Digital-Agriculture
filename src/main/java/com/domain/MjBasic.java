package com.domain;

import lombok.Data;

import java.util.Date;

@Data
public class MjBasic {
    private String mjBasicId;
    private String mjTelephone;
    private String mjPassword;
    private String mjSalt;
    private Date mjRegisterDate;
    private Date mjLastLoginDate;
    private Long mjLoginCount;
}
