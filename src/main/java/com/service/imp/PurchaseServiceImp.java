package com.service.imp;

import com.common.constant.UserConstant;
import com.dao.PurchaseDao;
import com.domain.Purchases;
import com.exception.GlobalException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.service.PurchaseService;
import com.common.commonUtils.ObjectId;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PurchaseServiceImp implements PurchaseService {

    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    RedisService redisService;

    @Autowired
    NhServiceImp nhService;

    @Override
    public void deleteRequirement(String id, String type) {
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals("NH")) {
                purchaseDao.deleteNhRequirement(id);
            } else if(type.toUpperCase().equals("MJ")) {
                purchaseDao.deleteMjRequirement(id);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
    }

    @Override
    public void releaseRequirement(String type, Purchases purchases) {
        purchases.setPurchasesId(ObjectId.get().toString());
        int res = 0;
        String basicId = purchases.getBasicId();
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals("NH")) {
                Boolean flag = nhService.existByBasicId(basicId);
                if(flag == false)
                    throw new GlobalException(CodeMsg.NH_NOT_EXISTS);
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

    @Override
    public PageInfo<Purchases> getRequirementList(String type, String id, int currentPage, int size) {
        List<Purchases> list = null;
        PageHelper.startPage(currentPage, size);
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals(UserConstant.USER_TYPE_MJ)) {
                if(StringUtils.isNotBlank(id)) {
                    list = purchaseDao.getMjRequirementList(id);
                } else {
                    list = purchaseDao.getNhRequirementList(null);
                }
            } else if(type.toUpperCase().equals(UserConstant.USER_TYPE_NH)) {
                if(StringUtils.isNotBlank(id)) {
                    list = purchaseDao.getNhRequirementList(id);
                } else {
                    list = purchaseDao.getMjRequirementList(null);
                }
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        PageInfo<Purchases> purchasesPageInfo = new PageInfo<Purchases>(list);
        return purchasesPageInfo;
    }

    @Override
    public Purchases getRequirement(String type, String id) {
        Purchases purchases = null;
        try {
            //TODO 通过枚举判断类型
            if(type.toUpperCase().equals("NH")) {
                purchases = purchaseDao.getNhRequirement(id);
            } else if(type.toUpperCase().equals("MJ")) {
                purchases = purchaseDao.getMjRequirement(id);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        if(null == purchases) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return purchases;
    }

    @Override
    @Transactional
    public void updateRequirement(String id, String type, Purchases purchases) {
        deleteRequirement(id, type);
        releaseRequirement(type, purchases);
    }
}
