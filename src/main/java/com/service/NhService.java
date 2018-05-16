package com.service;

import com.dao.NhDao;
import com.domain.NhBasic;
import com.result.CodeMsg;
import com.util.MD5Util;
import com.util.SaltUtil;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class NhService {

    @Autowired
    NhDao nhDao;

    public CodeMsg register(NhRegisterVo vo) {
        if(null == vo) {
            return CodeMsg.BIND_ERROR;
        }
        String telephone = vo.getNhTelephone();
        //查询手机号是否已经注册
        NhBasic nh = nhDao.getNhBasicByTelephone(telephone);
        if(null != nh) {
            return CodeMsg.TELEPHONE_REPEAT;
        }
        NhBasic nhBasic = new NhBasic();
        nhBasic.setNhId(UUID.randomUUID().toString());
        nhBasic.setNhTelephone(telephone);
        String inputPass = vo.getNhPassword();
        String salt = SaltUtil.getSalt(8);
        String dbPass = MD5Util.inputPassToDBPass(inputPass, salt);
        nhBasic.setNhSalt(salt);
        nhBasic.setNhPassword(dbPass);
        int res = nhDao.register(nhBasic);
        if(res != 1) {
            return CodeMsg.SERVER_ERROR;
        }
        return CodeMsg.SUCCESS;
    }

    public NhBasic getNhBasicByTelephone(String telephone) {
        return nhDao.getNhBasicByTelephone(telephone);
    }

    public CodeMsg login(NhLoginVo vo) {
        String nhTelephone = vo.getNhTelephone();
        String nhPassword = vo.getNhPassword();
        //判断用户是否存在
        NhBasic nhBasic = getNhBasicByTelephone(nhTelephone);
        if(null == nhBasic) {
            return CodeMsg.NH_NOT_EXISTS;
        }
        //验证密码
        String dbPass = nhBasic.getNhPassword();
        String salt = nhBasic.getNhSalt();
        String calcPass = MD5Util.formPassToDBPass(nhPassword, salt);
        if(!calcPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}
