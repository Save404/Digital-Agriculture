package com.dto;

import com.domain.Permission;
import lombok.Data;

import java.util.List;

@Data
public class GovPmsnDto {
    private String govId;
    private String govAccount;
    private String govPassword;
    private String govName;
    private String govDepartment;
    private String govAreaCode;
    private String govSalt;
    private Data govRegisterDate;
    private Data govLastLoginDate;
    private Long govLoginCount;
    private List<Permission> permissions;
}
