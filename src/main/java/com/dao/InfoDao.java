package com.dao;

import com.vo.CPView;
import com.vo.PCAView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InfoDao {

    @Select("select * from province_city_area_view where code_a = #{areaCode}")
    PCAView getPCAViewByAreaCode(@Param("areaCode") String areaCode);

    @Select("select * from category_product_view where p_code = #{pCode}")
    CPView getCPViewByPCode(@Param("pCode")  String pCode);
}
