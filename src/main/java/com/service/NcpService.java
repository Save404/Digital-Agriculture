package com.service;

import com.dao.NcpDao;
import com.domain.*;
import com.dto.NcpAllListDto;
import com.dto.NcpListDto;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.util.commonUtils.StringUtils;
import com.util.commonUtils.UUIDUtil;
import com.vo.CPView;
import com.vo.NcpView;
import com.vo.PCAView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NcpService {

    @Autowired
    NcpDao ncpDao;

    @Autowired
    NhService nhService;

    @Autowired
    InfoService infoService;

    @Transactional
    public Boolean addNcpInfo(NcpBasic ncpBasic, NcpMore ncpMore){
        //输入参数检验
        if (null == ncpBasic || null == ncpMore){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        //设置参数值
        String id = UUIDUtil.uuid();
        ncpBasic.setNcpBasicId(id);
        ncpMore.setNcpBasicId(id);
        ncpMore.setNcpMoreId(UUIDUtil.uuid());
        //数据交付给dao层处理
        try {
            if(ncpDao.addNcpBasicInfo(ncpBasic) != 1 || ncpDao.addNcpMoreInfo(ncpMore) != 1)
                throw new GlobalException(CodeMsg.SERVER_ERROR);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return true;
    }

    public List<Category2> getCategory2ByCategory1(String f2Code) {
        return ncpDao.getCategory2ByCategory1(f2Code);
    }

    public List<Category3> getCategory3ByCategory2(String f3Code) {
        return ncpDao.getCategory3ByCategory2(f3Code);
    }

    public List<Product> getProductByCategory3(String fCode) {
        return ncpDao.getProductByCategory3(fCode);
    }

    public List<Category1> getCategory1All() {
        return ncpDao.getCategory1All();
    }

    public List<NcpListDto> getNcpList(NhBasic nhBasic) {
        if(null == nhService.getNhBasicByTelephone(nhBasic.getNhTelephone())) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        List<NcpListDto> list = null;
        try {
            list = ncpDao.getNcpList(nhBasic.getNhBasicId());
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }

    public NcpView getNcpByNcpBasicId(String ncpBasicId) {
        NcpView ncpView = null;
        try {
            ncpView = ncpDao.getNcpByNcpBasicId(ncpBasicId);
            if (ncpView == null){
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
            String ncpPCode = ncpView.getNcpPCode();
            String ncpAreaCode = ncpView.getNcpAreaCode();
            PCAView pcaView = infoService.getPCAViewByAreaCode(ncpAreaCode);
            CPView cpView = infoService.getCPViewByPCode(ncpPCode);
            ncpView.setCpView(cpView);
            ncpView.setPcaView(pcaView);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return ncpView;
    }

    @Transactional
    public void modifyNcp(String ncpBasicId, NcpBasic ncpBasic, NcpMore ncpMore) {
        if (null == ncpBasic || null == ncpMore || StringUtils.isEmpty(ncpBasicId)){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        deleteNcp(ncpBasicId);
        addNcpInfo(ncpBasic, ncpMore);
    }

    public List<NcpAllListDto> getMjAllNcpList() {
        List<NcpAllListDto> list = null;
        try {
            list = ncpDao.getMjAllNcpList();
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }

    public void deleteNcp(String ncpBasicId) {
        try {
            if(ncpDao.deleteMoreByBasicId(ncpBasicId) != 1 || ncpDao.deleteBasicById(ncpBasicId) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    public void onSell(String ncpBasicId) {
        try {
            if(ncpDao.onSell(ncpBasicId) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    public List<NcpAllListDto> getByProduct(String pCode) {
        List<NcpAllListDto> list = null;
        try {
            list = ncpDao.getByProduct(pCode);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }
}
