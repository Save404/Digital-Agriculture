package com.dto;

import lombok.Data;

import java.util.Date;

@Data
public class NcpListDto {
    private String ncpBasicId;
    private String ncpName;
    private String c1Name;
    private String c2Name;
    private String c3Name;
    private String nameP;
    private String nameC;
    private String nameA;
    private String ncpFeature;
    private int ncpStatus;
    private Date ncpPublishDate;
}
