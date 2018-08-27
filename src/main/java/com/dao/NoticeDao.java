package com.dao;

import com.domain.Notice;
import com.vo.NoticeView;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoticeDao {

    @Insert("insert into notice values(#{noticeId}, #{noticeTitle}, " +
            "#{noticeContent}, #{departmentId}, #{noticeLevel}, #{createTime}, #{readNum})")
    public int addNotice(Notice notice);

    @Select("select * from notice where notice_id = #{id}")
    public Notice findNoticeByNoticeId(@Param("id") String id);

    @Delete("delete from notice where notice_id = #{id}")
    public int deleteNoticeByNoticeId(@Param("id") String id);

    @Select("select * from notice_view where notice_id = #{id}")
    public NoticeView findNoticeViewById(@Param("id") String id);

    @Select("select * from notice_view where region_code in (\n" +
            "\tselect code_p from province_city_area_view where code_a = #{code} union\n" +
            "\tselect code_c from province_city_area_view where code_a = #{code} union\n" +
            "\tselect code_a from province_city_area_view where code_a = #{code}\n" +
            ") order by create_time desc")
    public List<NoticeView> findNoticesByRegionCodeOrderByTimeDesc(@Param("code") String code);

    @Select("select * from notice_view where department_id = #{id} order by create_time desc")
    public List<NoticeView> findNoticesByDepartmentIdOrderByTimeDesc(@Param("id") int id);
}
