package com.controller;

import com.domain.MjBasic;
import com.domain.NhBasic;
import com.domain.Order;
import com.dto.NhOrderListDto;
import com.result.Result;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    /**
     * 买家下单
     * @param order
     * @param mjBasic
     * @return
     */
    @RequestMapping(value = "/add_order", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addOrder(@Valid Order order, MjBasic mjBasic) {
        order.setMjBasicId(mjBasic.getMjBasicId());
        orderService.addOrder(order);
        return Result.success(true);
    }

    /**
     * 农户获取订单列表
     * @param nhBasic
     * @return
     */
    @RequestMapping(value = "/nh_get_order_list", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<NhOrderListDto>> nhGetOrderList(NhBasic nhBasic) {
        List<NhOrderListDto> listDtos = orderService.getNhOrderList(nhBasic.getNhBasicId());
        return Result.success(listDtos);
    }

}
