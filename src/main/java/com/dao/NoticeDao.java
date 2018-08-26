package com.dao;

import com.domain.Notice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeDao {
    @Insert("insert into notice values(#{noticeId}, #{noticeTitle}, " +
            "#{noticeContent}, #{departmentId}, #{noticeLevel}, #{createTime}, #{readNum})")
    public int addNotice(Notice notice);
}
