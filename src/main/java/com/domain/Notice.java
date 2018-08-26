package com.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private String noticeId;
    private String noticeTitle;
    private String noticeContent;
    private int departmentId;
    private int noticeLevel;
    private Date createTime;
    private int readNum;
}
