package com.service.imp;

import com.common.commonUtils.UUIDUtil;
import com.dao.NoticeDao;
import com.domain.Notice;
import com.dto.GovPmsnDto;
import com.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NoticeServiceImp implements NoticeService {

    @Autowired
    NoticeDao dao;

    @Override
    public boolean addNotice(GovPmsnDto gov, Notice notice) {
        notice.setNoticeId(UUIDUtil.uuid());
        notice.setDepartmentId(gov.getGovDepartmentId());
        notice.setCreateTime(new Date());
        notice.setReadNum(0);
        return dao.addNotice(notice) == 1;
    }
}
