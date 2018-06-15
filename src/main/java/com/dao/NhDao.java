package com.dao;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
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

    @Select("select pca.name_p, pca.name_c, pca.name_a,nh_more.nh_real_name, nh_more.nh_sex,nh_more.nh_origin," +
            "nh_more.nh_nation,nh_more.nh_politics,nh_more.nh_id_card,nh_more.nh_ghdw_address,nh_more.nh_ghdw_phone, nh_more.nh_ghdw_area_code " +
            "from nh_more,province_city_area_view as pca where " +
            "nh_more.nh_ghdw_area_code=pca.code_a and nh_basic_id = #{nhBasicId}")
    NhMoreDto getNhMoreDtoByBasicId(@Param("nhBasicId") String nhBasicId);

    @Delete("delete from nh_more where nh_basic_id = #{nhBasicId}")
    int deleteMoreByBasicId(@Param("nhBasicId") String nhBasicId);
}
