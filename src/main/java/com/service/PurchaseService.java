package com.service;

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
}
