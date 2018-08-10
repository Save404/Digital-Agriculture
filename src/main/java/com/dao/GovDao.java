package com.dao;

import com.domain.Gov;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GovDao {


    @Select("select * from gov where gov_account = #{account}")
    Gov getGovByAccount(@Param("account") String account);
}
