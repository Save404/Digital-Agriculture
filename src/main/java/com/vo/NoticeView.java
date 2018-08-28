package com.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class NoticeView {
    private String noticeId;
    private String noticeTitle;
    private String noticeContent;
    @JsonIgnore
    private int departmentId;
    private int noticeLevel;
    private Date createTime;
    private int readNum;
    private String departmentName;
    @JsonIgnore
    private String regionCode;
    private String regionName;
}
