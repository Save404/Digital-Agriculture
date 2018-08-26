package com.service;

import com.domain.Notice;
import com.dto.GovPmsnDto;

public interface NoticeService {
    public boolean addNotice(GovPmsnDto gov, Notice notice);
}
