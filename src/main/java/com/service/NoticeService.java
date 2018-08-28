package com.service;

import com.domain.Notice;
import com.dto.GovPmsnDto;
import com.github.pagehelper.PageInfo;
import com.vo.NoticeView;

public interface NoticeService {
    public boolean addNotice(GovPmsnDto gov, Notice notice);
    public boolean deleteNotice(GovPmsnDto gov, String id);
    public boolean updateNotice(GovPmsnDto gov, String id, Notice notice);
    public NoticeView getDetailNotice(String id);
    public PageInfo<NoticeView> getNoticeList(String type, String id, int currentPage, int size);
}
