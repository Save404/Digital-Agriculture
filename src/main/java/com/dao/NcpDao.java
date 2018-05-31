package com.dao;

import com.domain.*;
import com.vo.NcpView;
import com.vo.NcpView1;
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
    public int addNcpBasicInfo(NcpBasic ncpBasic);

    @InsertProvider(type=com.sql.NcpSqlProvider.class, method="insertNcpMoreInfo")
    public int addNcpMoreInfo(NcpMore ncpMore);

    List<NcpView1> getNcpList(String nhBasic);

    NcpView getNcpByNcpBasicId(String ncpBasicId);
}
