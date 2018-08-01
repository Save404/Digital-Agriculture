package com.service.imp;

import com.common.constant.ContractConstant;
import com.common.constant.UserConstant;
import com.dao.ContractDao;
import com.domain.Contract;
import com.exception.GlobalException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.result.CodeMsg;
import com.service.ContractService;
import com.common.commonUtils.ObjectId;
import com.service.NhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImp implements ContractService {

    @Autowired
    ContractDao contractDao;

    @Autowired
    NhService nhService;

    @Override
    public void createContract(Contract contract) {
        try {
            //生成主键id
            contract.setContractId(ObjectId.get().toString());
            int res = contractDao.createContract(contract);
            if(res != 1)
                throw new GlobalException(CodeMsg.CONTRACT_CREATE_ERROR);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public Contract getContract(String id) {
        Contract contract;
        try {
            contract = contractDao.getContract(id);
            if(null == contract) {
                throw new GlobalException(CodeMsg.CONTRACT_GET_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return contract;
    }

    @Override
    public void updateContractStatu(String id, String statu) {
        //判断合同是否存在
        if(!existById(id))
            throw new GlobalException(CodeMsg.CONTRACT_GET_ERROR);
        //TODO 优化if else
        try {
            int res = 0;
            if(statu.toUpperCase().equals("AGREE")) {
                res = contractDao.updateContractStatu(id, ContractConstant.CONTRACT_STATU_AGREE);
            } else if(statu.toUpperCase().equals("CANCEL")) {
                res = contractDao.updateContractStatu(id, ContractConstant.CONTRACT_STATU_CANCEL);
            } else if(statu.toUpperCase().equals("SHIP")) {
                res = contractDao.updateContractStatu(id, ContractConstant.CONTRACT_STATU_SHIP);
            } else if(statu.toUpperCase().equals("FINISH")) {
                res = contractDao.updateContractStatu(id, ContractConstant.CONTRACT_STATU_FINISH);
            }
            if(res != 1)
                throw new GlobalException(CodeMsg.CONTRACT_STATU_ERROR);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public Boolean existById(String id) {
        int res;
        try {
            res = contractDao.existById(id);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return res == 0 ? false : true;
    }

    @Override
    public void completeContract(Contract contract) {
        String id = contract.getContractId();
        if(!existById(id))
            throw new GlobalException(CodeMsg.CONTRACT_GET_ERROR);
        try {
            int res;
            res = contractDao.completeContract(contract);
            if(res != 1)
                throw new GlobalException(CodeMsg.CONTRACT_COMPLETE_ERROR);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public void updatePayStatu(String id, String statu) {
        //TODO 判断订单状态
        if(!existById(id))
            throw new GlobalException(CodeMsg.CONTRACT_GET_ERROR);
        try {
            int res = 0;
            if(statu.toUpperCase().equals("FINISH"))
                res = contractDao.updatePayStatu(id, ContractConstant.CONTRACT_PAY_STATU_FINISH);
            if(res != 1)
                throw new GlobalException(CodeMsg.CONTRACT_PAY_STATU_ERROR);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public PageInfo<Contract> getContractList(String type, String id, int currentPage, int size) {
        List<Contract> list;
        //TODO 验证用户是否存在
        try {
            if(type.toUpperCase().equals(UserConstant.USER_TYPE_NH)) {
                if(!nhService.existByBasicId(id))
                    throw new GlobalException(CodeMsg.USER_ERROR);
                PageHelper.startPage(currentPage, size);
                list = contractDao.getNhContractList(id);
            } else if(type.toUpperCase().equals(UserConstant.USER_TYPE_MJ)) {
                PageHelper.startPage(currentPage, size);
                list = contractDao.getMJContractList(id);
            } else {
                throw new GlobalException(CodeMsg.USER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        PageInfo<Contract> pageInfo = new PageInfo<Contract>(list);
        return pageInfo;
    }

}
