package com.dao;

import com.domain.*;
import com.dto.NcpAllListDto;
import com.dto.NcpListDto;
import com.vo.NcpView;
import org.apache.ibatis.annotations.*;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NcpDao {

    @Select("select * from category1")
    List<Category1> getCategory1All();

    @Select("select * from category2 where f2_code = #{f2Code}")
    List<Category2> getCategory2ByCategory1(@Param("f2Code") String f2Code);

    @Select("select * from category3 where f3_code = #{f3Code}")
    List<Category3> getCategory3ByCategory2(@Param("f3Code") String f3Code);

    @Select("select * from product where f_code = #{fCode}")
    List<Product> getProductByCategory3(@Param("fCode") String fCode);

    @InsertProvider(type=com.sql.NcpSqlProvider.class, method = "insertNcpBasicInfo")
    int addNcpBasicInfo(NcpBasic ncpBasic);

    @InsertProvider(type=com.sql.NcpSqlProvider.class, method="insertNcpMoreInfo")
    int addNcpMoreInfo(NcpMore ncpMore);

    @Delete("delete from ncp_more where ncp_basic_id = #{ncpBasicId}")
    int deleteMoreByBasicId(@Param("ncpBasicId") String ncpBasicId);

    @Delete("delete from ncp_basic where ncp_basic_id = #{ncpBasicId}")
    int deleteBasicById(@Param("ncpBasicId") String ncpBasicId);

    @Select("select ncp_basic.ncp_basic_id, ncp_basic.ncp_name, " +
            "cp.c1_name, cp.c2_name, cp.c3_name, ncp_basic.ncp_status, " +
            "pca.name_p, pca.name_c, pca.name_a, ncp_basic.ncp_feature, " +
            "ncp_basic.ncp_publish_date from ncp_basic, category_product_view as cp, province_city_area_view as pca " +
            "where ncp_basic.ncp_p_code = cp.p_code and ncp_basic.ncp_area_code = pca.code_a and ncp_basic.nh_basic_id = #{nhid}")
    List<NcpListDto> getNcpList(@Param("nhid") String nhBasic);

    @Select("select * from ncp_view where ncp_basic_id = #{ncpBasicId}")
    NcpView getNcpByNcpBasicId(@Param("ncpBasicId") String ncpBasicId);

    @Select("select n.ncp_basic_id, n.ncp_name, n.ncp_publish_date, n.ncp_address, n.ncp_feature, n.ncp_brand, " +
            "n.ncp_supply_amount, n.supply_unit, n.ncp_price, n.price_unit, n.ncp_status, n.ncp_detail, n.ncp_package, " +
            "n.ncp_quality, n.ncp_delivery_info, n.ncp_growth_info, n.ncp_growth_surrounding, n.ncp_supply_period_start," +
            "n.ncp_supply_period_end, n.ncp_img, n.ncp_plant_area, n.plant_unit, n.nh_basic_id, " +
            "cpv.c1_name, cpv.c2_name, cpv.c3_name, pca.name_p, pca.name_c, pca.name_a " +
            "from ncp_view as n, category_product_view as cpv, province_city_area_view as pca " +
            "where n.ncp_area_code = pca.code_a and n.ncp_p_code = cpv.p_code")
    List<NcpAllListDto> getAllNcpList();

    @Select("select n.ncp_basic_id, n.ncp_name, n.ncp_publish_date, n.ncp_address, n.ncp_feature, n.ncp_brand, " +
            "n.ncp_supply_amount, n.supply_unit, n.ncp_price, n.price_unit, n.ncp_status, n.ncp_detail, n.ncp_package, " +
            "n.ncp_quality, n.ncp_delivery_info, n.ncp_growth_info, n.ncp_growth_surrounding, n.ncp_supply_period_start," +
            "n.ncp_supply_period_end, n.ncp_img, n.ncp_plant_area, n.plant_unit, n.nh_basic_id, " +
            "cpv.c1_name, cpv.c2_name, cpv.c3_name, pca.name_p, pca.name_c, pca.name_a " +
            "from ncp_view as n, category_product_view as cpv, province_city_area_view as pca " +
            "where n.ncp_area_code = pca.code_a and n.ncp_p_code = cpv.p_code and n.ncp_status = 1")
    List<NcpAllListDto> getMjAllNcpList();

    @Update("update ncp_basic set ncp_status = (ncp_status+1)%2 where ncp_basic_id= #{ncpBasicId}")
    int onSell(@Param("ncpBasicId") String ncpBasicId);

    @Select("select n.ncp_basic_id, n.ncp_name, n.ncp_publish_date, n.ncp_address, n.ncp_feature, n.ncp_brand, " +
            "n.ncp_supply_amount, n.supply_unit, n.ncp_price, n.price_unit, n.ncp_status, n.ncp_detail, n.ncp_package, " +
            "n.ncp_quality, n.ncp_delivery_info, n.ncp_growth_info, n.ncp_growth_surrounding, n.ncp_supply_period_start," +
            "n.ncp_supply_period_end, n.ncp_img, n.ncp_plant_area, n.plant_unit, n.nh_basic_id, " +
            "cpv.c1_name, cpv.c2_name, cpv.c3_name, pca.name_p, pca.name_c, pca.name_a " +
            "from ncp_view as n, category_product_view as cpv, province_city_area_view as pca " +
            "where n.ncp_area_code = pca.code_a and n.ncp_p_code = cpv.p_code and n.ncp_status = 1 and n.ncp_p_code = #{pCode}")
    List<NcpAllListDto> getByProduct(@Param("pCode") String pCode);
}
