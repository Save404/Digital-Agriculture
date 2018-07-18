package com.domain;

import lombok.Data;

import java.util.Date;

@Data
public class NhBasic {
    private String nhBasicId;
    private String nhTelephone;
    private String nhPassword;
    private String nhSalt;
    private Date nhRegisterDate;
    private Date nhLastLoginDate;
    private Long nhLoginCount;
}
