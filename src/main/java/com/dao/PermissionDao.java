package com.dao;

import com.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PermissionDao {

    @Select("select * from permission where pmsn_id in (select pmsn_id from gov_pmsn where gov_id = #{id})")
    List<Permission> getPermissionsByGovAccount(@Param("id") String account);
}
