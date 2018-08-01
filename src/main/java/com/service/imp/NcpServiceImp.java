package com.service.imp;

import com.dao.NcpDao;
import com.domain.*;
import com.dto.NcpAllListDto;
import com.dto.NcpListDto;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.common.commonUtils.StringUtils;
import com.common.commonUtils.UUIDUtil;
import com.service.NcpService;
import com.vo.CPView;
import com.vo.NcpView;
import com.vo.PCAView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NcpServiceImp implements NcpService {

    @Autowired
    NcpDao ncpDao;

    @Autowired
    NhServiceImp nhService;

    @Autowired
    InfoService infoService;

    @Transactional
    @Override
    public void addNcpInfo(NcpBasic ncpBasic, NcpMore ncpMore){
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
    }

    @Override
    public List<NcpListDto> getNcpList(NhBasic nhBasic) {
        if(null == nhService.getNhBasicByTelephone(nhBasic.getNhTelephone())) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        List<NcpListDto> list;
        try {
            list = ncpDao.getNcpList(nhBasic.getNhBasicId());
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }

    @Override
    public NcpView getNcpByNcpBasicId(String ncpBasicId) {
        NcpView ncpView;
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
    @Override
    public void modifyNcp(String ncpBasicId, NcpBasic ncpBasic, NcpMore ncpMore) {
        deleteNcp(ncpBasicId);
        addNcpInfo(ncpBasic, ncpMore);
    }

    public List<NcpAllListDto> getMjAllNcpList() {
        List<NcpAllListDto> list;
        try {
            list = ncpDao.getMjAllNcpList();
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }

    @Transactional
    @Override
    public void deleteNcp(String ncpBasicId) {
        try {
            if(ncpDao.deleteMoreByBasicId(ncpBasicId) != 1 || ncpDao.deleteBasicById(ncpBasicId) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public void onSell(String ncpBasicId) {
        try {
            if(ncpDao.onSell(ncpBasicId) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public List<NcpAllListDto> getByProduct(String pCode) {
        List<NcpAllListDto> list;
        try {
            list = ncpDao.getByProduct(pCode);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return list;
    }
}
