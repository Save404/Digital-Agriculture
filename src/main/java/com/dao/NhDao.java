package com.dao;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.sql.NhSqlProvider;
import org.apache.ibatis.annotations.*;

@Mapper
public interface NhDao {


    @Insert("insert into nh_basic(nh_basic_id, nh_telephone, nh_password, nh_salt) values (" +
            "#{nhBasicId}, #{nhTelephone}, #{nhPassword}, #{nhSalt})")
    //@SelectKey(statement="select LAST_INSERT_ID()", keyProperty ="nhId", keyColumn="nh_id", before=false, resultType=String.class)
    int register(NhBasic nhBasic);

    @Select("select * from nh_basic where nh_telephone=#{telephone}")
    NhBasic getNhBasicByTelephone(@Param("telephone") String telephone);

    @InsertProvider(type=NhSqlProvider.class, method="insertNhDetailInfo")
    int addNhDetailInfo(NhMore nhMore);
}
