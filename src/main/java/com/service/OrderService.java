package com.service;

import com.dao.OrderDao;
import com.domain.MjBasic;
import com.domain.Order;
import com.dto.NhOrderListDto;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.result.Result;
import com.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;

    public Boolean addOrder(Order order) {
        order.setOrderId(UUIDUtil.uuid());
        try {
            if(orderDao.addOrder(order) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return true;
    }

    public List<NhOrderListDto> getNhOrderList(String nhBasicId) {
        List<NhOrderListDto> listDtos = null;
        try {
            listDtos = orderDao.getNhOrderList(nhBasicId);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return listDtos;
    }
}
