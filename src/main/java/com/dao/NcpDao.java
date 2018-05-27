package com.dao;

import com.domain.Category2;
import com.domain.Category3;
import com.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NcpDao {

    @Select("select * from category2 where f2_code = #{f2Code}")
    List<Category2> getCategory2ByCategory1(@Param("f2Code") String f2Code);

    @Select("select * from category3 where f3_code = #{f3Code}")
    List<Category3> getCategory3ByCategory2(@Param("f3Code") String f3Code);

    @Select("select * from product where f_code = #{fCode}")
    List<Product> getProductByCategory3(@Param("fCode") String fCode);

}
