package com.service;

import com.dao.InfoDao;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.vo.CPView;
import com.vo.PCAView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    @Autowired
    InfoDao infoDao;

    public PCAView getPCAViewByAreaCode(String areaCode) {
        PCAView pcaView = null;
        try {
            pcaView = infoDao.getPCAViewByAreaCode(areaCode);
            if(null == pcaView) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return pcaView;
    }

    public CPView getCPViewByPCode(String pCode) {
        CPView cpView = null;
        try {
            cpView = infoDao.getCPViewByPCode(pCode);
            if(null == cpView) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return cpView;
    }
}
