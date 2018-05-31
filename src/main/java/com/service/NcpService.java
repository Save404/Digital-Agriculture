package com.service;

import com.dao.NcpDao;
import com.domain.*;
import com.exception.GlobalException;
import com.result.CodeMsg;
import com.vo.NcpView;
import com.vo.NcpView1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
public class NcpService {

    @Autowired
    NcpDao ncpDao;

    @Transactional
    public Boolean addNcpInfo(NcpBasic ncpBasic, NcpMore ncpMore){
        //输入参数检验
        if (null == ncpBasic || null == ncpMore){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        //设置参数值
        String id = UUID.randomUUID().toString();
        ncpBasic.setNcpBasicId(id);
        ncpMore.setNcpBasicId(id);
        ncpMore.setNcpMoreId(UUID.randomUUID().toString());
        //数据交付给dao层处理
        if(ncpDao.addNcpBasicInfo(ncpBasic) != 1 || ncpDao.addNcpMoreInfo(ncpMore) != 1)
            throw new GlobalException(CodeMsg.SERVER_ERROR);
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

    public List<NcpView1> getNcpList(NhBasic nhBasic) {
        if (nhBasic == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        List<NcpView1> list = ncpDao.getNcpList(nhBasic.getNhBasicId());
        return list;
    }

    public NcpView getNcpByNcpBasicId(String ncpBasicId) {
        NcpView ncpView = ncpDao.getNcpByNcpBasicId(ncpBasicId);
        if (ncpView == null){
            throw new GlobalException(CodeMsg.NCP_BASIC_ID_ERROR);
        }
        return ncpView;
    }
}
