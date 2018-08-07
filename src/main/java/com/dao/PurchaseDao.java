package com.dao;

import com.domain.Purchases;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PurchaseDao {

    @Delete("delete from nh_purchases where nh_purchases_id = #{id}")
    int deleteNhRequirement(@Param("id") String id);

    @Delete("delete from mj_purchases where mj_purchases_id = #{id}")
    int deleteMjRequirement(@Param("id") String id);

    int releaseNhRequirement(Purchases purchases);

    int releaseMjRequirement(Purchases purchases);

    List<Purchases> getNhRequirementList();

    List<Purchases> getMjRequirementList();

    Purchases getNhRequirement(String id);

    Purchases getMjRequirement(String id);

}
