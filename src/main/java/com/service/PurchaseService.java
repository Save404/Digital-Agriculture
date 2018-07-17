package com.service;

import com.dao.PurchaseDao;
import com.domain.Purchases;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.util.commonUtils.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    public void deleteRequirement(String id, String type) {
        int res = 0;
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals("NH")) {
                res = purchaseDao.deleteNhRequirement(id);
            } else if(type.toUpperCase().equals("MJ")) {
                res = purchaseDao.deleteMjRequirement(id);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        if(res != 1)
            throw new GlobalException(CodeMsg.DB_ERROR);
    }

    public void releaseRequirement(String type, Purchases purchases) {
        int res = 0;
        purchases.setPurchasesId(UUIDUtil.uuid());
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals("NH")) {
                res = purchaseDao.releaseNhRequirement(purchases);
            } else if(type.toUpperCase().equals("MJ")) {
               res = purchaseDao.releaseMjRequirement(purchases);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        if(res != 1) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }
}
