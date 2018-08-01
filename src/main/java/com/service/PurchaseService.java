package com.service;

<<<<<<< HEAD
import com.domain.Purchases;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PurchaseService {

    /** 删除求购信息 */
    void deleteRequirement(String id, String type);

    /** 发布求购信息 */
    void releaseRequirement(String type, Purchases purchases);

    /** 获取求购信息列表 */
    PageInfo<Purchases> getRequirementList(String type, int currentPage, int size);

    /** 获取求购信息 */
    Purchases getRequirement(String type, String id);

    /** 修改求购信息 */
    void updateRequirement(String id, String type, Purchases purchases);
=======
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
>>>>>>> origin/master
}
