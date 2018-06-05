package com.dao;

import com.domain.MjBasic;
import com.domain.MjMore;
import com.domain.NhBasic;
import com.dto.MjMoreDto;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MjDao {

    @Insert("insert into mj_basic (mj_basic_id, mj_telephone, mj_password, mj_salt) values (" +
            "#{mjBasicId}, #{mjTelephone}, #{mjPassword}, #{mjSalt})")
    //@SelectKey(statement="select LAST_INSERT_ID()", keyProperty ="nhId", keyColumn="nh_id", before=false, resultType=String.class)
    int register(MjBasic mjBasic);

    @Select("select * from mj_basic where mj_telephone=#{telephone}")
    MjBasic getMjBasicByTelephone(@Param("telephone") String telephone);

    @Delete("delete from mj_more where mj_basic_id = #{mjBasicId}")
    int deleteMoreByBasicId(@Param("mjBasicId") String mjBasicId);

    int addMjDetailInfo(MjMore mjMore);

    @Select("select pca.name_p, pca.name_c, pca.name_a,mj_more.mj_real_name, mj_more.mj_sex,mj_more.mj_origin," +
            "mj_more.mj_nation,mj_more.mj_politics,mj_more.mj_id_card," +
            "mj_more.mj_pay_password,mj_more.mj_pay_salt from mj_more,province_city_area_view as pca where " +
            "mj_more.mj_a_code=pca.code_a and mj_basic_id = #{mjBasicId}")
    MjMoreDto getMjMoreDtoByBasicId(@Param("mjBasicId") String mjBasicId);
}
