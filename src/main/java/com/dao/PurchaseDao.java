package com.dao;

import com.domain.Purchases;
import org.apache.ibatis.annotations.Delete;
<<<<<<< HEAD
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

=======
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

>>>>>>> origin/master
@Mapper
public interface PurchaseDao {

    @Delete("delete from nh_purchases where nh_purchases_id = #{id}")
    int deleteNhRequirement(@Param("id") String id);

    @Delete("delete from mj_purchases where mj_purchases_id = #{id}")
    int deleteMjRequirement(@Param("id") String id);

<<<<<<< HEAD
    int releaseNhRequirement(Purchases purchases);

    int releaseMjRequirement(Purchases purchases);

    List<Purchases> getNhRequirementList();

    Purchases getNhRequirement(String id);
=======
    @Insert("INSERT INTO\n" +
            "        nh_purchases (nh_purchases_id, nh_basic_id, title, content, telephone)\n" +
            "        VALUES\n" +
            "        (#{purchasesId}, #{basicId},\n" +
            "        #{title}, #{content}, #{telephone})")
    int releaseNhRequirement(Purchases purchases);

    int releaseMjRequirement(Purchases purchases);
>>>>>>> origin/master
}
