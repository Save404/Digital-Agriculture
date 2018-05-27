package com.service;

import com.dao.NcpDao;
import com.domain.NcpBasic;
import com.domain.NcpMore;
import com.domain.NhBasic;
import com.exception.AgricultureException;
import com.result.CodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.UUID;

@Service
public class NcpService {

    @Autowired
    NcpDao ncpDao;

    @Transactional
    public CodeMsg addNcpInfo(NcpBasic ncpBasic, NcpMore ncpMore){

        //输入参数检验
        if (ncpBasic == null || ncpMore == null){
            return CodeMsg.BIND_ERROR;
        }

        //设置参数值
        String id = UUID.randomUUID().toString();
        ncpBasic.setNcpBasicId(id);
        ncpMore.setNcpBasicId(id);
        ncpMore.setNcpMoreId(UUID.randomUUID().toString());

        //数据交付给dao层处理

        try{
            if(ncpDao.addNcpBasicInfo(ncpBasic) != 1 || ncpDao.addNcpMoreInfo(ncpMore) != 1){
                throw  new AgricultureException(CodeMsg.NCP_ADD_FAIL);
            }
        }catch(Exception e){
            throw new AgricultureException(CodeMsg.NCP_ADD_FAIL);
        }

        return CodeMsg.SUCCESS;
    }
}
