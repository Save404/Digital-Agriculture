package com.dao;

import com.domain.MjBasic;
import com.domain.NhBasic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MjDao {

    @Insert("insert into mj_basic (mj_basic_id, mj_telephone, mj_password, mj_salt) values (" +
            "#{mjBasicId}, #{mjTelephone}, #{mjPassword}, #{mjSalt})")
    //@SelectKey(statement="select LAST_INSERT_ID()", keyProperty ="nhId", keyColumn="nh_id", before=false, resultType=String.class)
    int register(MjBasic mjBasic);

    @Select("select * from mj_basic where mj_telephone=#{telephone}")
    MjBasic getMjBasicByTelephone(@Param("telephone") String telephone);
}
