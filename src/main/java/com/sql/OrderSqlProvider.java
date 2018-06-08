package com.sql;

import com.domain.Order;
import com.util.SqlProviderlUtil;

import java.util.HashMap;
import java.util.Map;

public class OrderSqlProvider {

    public String insertOrderInfo(final Order order) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("order_id", order.getOrderId());
        map.put("mj_basic_id", order.getMjBasicId());
        map.put("order_payment", order.getOrderPayment());
        map.put("address_id", order.getAddressId());
        map.put("nh_basic_id", order.getNhBasicid());
        map.put("order_number", order.getOrderNumber());
        map.put("order_unit", order.getOrderUnit());
        map.put("good_id", order.getGoodId());
        map.put("post_fee", order.getPostFee());
        return SqlProviderlUtil.returnInsertSql("orderInfo", map);
    }
}
