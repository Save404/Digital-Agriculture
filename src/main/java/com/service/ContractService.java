package com.service;

import com.domain.Contract;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ContractService {

    /** 创建合同 */
    void createContract(Contract contract);

    /** 获取合同 */
    Contract getContract(String id);

    /** 修改合同状态 */
    void updateContractStatu(String id, String statu);

    /** 通过id判断是否存在 */
    Boolean existById(String id);

    /** 卖家填写合同信息 */
    void completeContract(Contract contract);

    /** 更新支付状态 */
    void updatePayStatu(String id, String statu);

    /** 获取合同列表 */
    PageInfo<Contract> getContractList(String type, String id, int currentPage, int size);
}
