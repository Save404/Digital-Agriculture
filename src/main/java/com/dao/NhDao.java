package com.dao;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.sql.NhSqlProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NhDao {


    @Insert("insert into nh_basic(nh_basic_id, nh_telephone, nh_password, nh_salt) values (" +
            "#{nhBasicId}, #{nhTelephone}, #{nhPassword}, #{nhSalt})")
    int register(NhBasic nhBasic);

    @Select("select * from nh_basic where nh_telephone=#{telephone}")
    NhBasic getNhBasicByTelephone(@Param("telephone") String telephone);

    @Select("select * from nh_basic where nh_basic_id=#{nhBasicId}")
    NhBasic getNhBasicById(@Param("nhBasicId") String nhBasicId);

    @InsertProvider(type=NhSqlProvider.class, method="insertNhDetailInfo")
    int addNhDetailInfo(NhMore nhMore);

    @Select("select * from nh_more where nh_basic_id = #{nhBasicId}")
    NhMore getNhDetail(@Param("nhBasicId") String nhBasicId);

    @Delete("delete from nh_more where nh_more_id = #{nhMoreId}")
    int deleteMoreById(@Param("nhMoreId") String nhMoreId);
}
