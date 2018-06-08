package com.dao;

import com.domain.Order;
import com.dto.NhOrderListDto;
import com.sql.OrderSqlProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OrderDao {

    @InsertProvider(type=OrderSqlProvider.class, method="insertOrderInfo")
    int addOrder(Order order);

    @Select("select goods.good_name, pca.name_p, pca.name_a, pca.name_c, ord.order_id, ord.order_payment,ord.order_status," +
            "ord.pay_status, ord.post_status, ord.order_created, ord.order_number, ord.order_unit, ad.receiver_name, " +
            "ad.receiver_phone, ad.receiver_address, ord.post_fee, ord.buyer_message from address as ad, " +
            "orderinfo as ord, province_city_area_view as pca, goods where ord.good_id = goods.good_id and " +
            "ord.address_id = ad.address_id and ad.code_a = pca.code_a and ord.nh_basic_id = #{nhBasicId}")
    List<NhOrderListDto> getNhOrderList(@Param("nhBasicId") String nhBasicId);
}
