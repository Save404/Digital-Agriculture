package com.domain;

import lombok.Data;

@Data
public class Gov {
    private String govId;
    private String govAccount;
    private String govPassword;
    private String govName;
    private int govDepartmentId;
    private String govSalt;
    private Data govRegisterDate;
    private Data govLastLoginDate;
    private Long govLoginCount;
}
