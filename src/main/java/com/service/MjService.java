package com.service;

import com.dao.MjDao;
import com.domain.MjBasic;
import com.result.CodeMsg;
import com.util.MD5Util;
import com.util.SaltUtil;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MjService {

    @Autowired
    MjDao mjDao;

    public CodeMsg register(MjRegisterVo vo) {
        if(null == vo) {
            return CodeMsg.BIND_ERROR;
        }
        String telephone = vo.getMjTelephone();
        //查询手机号是否已经注册
        MjBasic mj = mjDao.getMjBasicByTelephone(telephone);
        if(null != mj) {
            return CodeMsg.TELEPHONE_REPEAT;
        }
        MjBasic mjBasic = new MjBasic();
        mjBasic.setMjId(UUID.randomUUID().toString());
        mjBasic.setMjTelephone(telephone);
        String inputPass = vo.getMjPassword();
        String salt = SaltUtil.getSalt(8);
        String dbPass = MD5Util.inputPassToDBPass(inputPass, salt);
        mjBasic.setMjSalt(salt);
        mjBasic.setMjPassword(dbPass);
        int res = mjDao.register(mjBasic);
        if(res != 1) {
            return CodeMsg.SERVER_ERROR;
        }
        return CodeMsg.SUCCESS;
    }

    public MjBasic getMjBasicByTelephone(String telephone) {
        return mjDao.getMjBasicByTelephone(telephone);
    }

    public CodeMsg login(MjLoginVo vo) {
        String mjTelephone = vo.getMjTelephone();
        String mjPassword = vo.getMjPassword();
        //判断用户是否存在
        MjBasic mjBasic = getMjBasicByTelephone(mjTelephone);
        if(null == mjBasic) {
            return CodeMsg.NH_NOT_EXISTS;
        }
        //验证密码
        String dbPass = mjBasic.getMjPassword();
        String salt = mjBasic.getMjSalt();
        String calcPass = MD5Util.formPassToDBPass(mjPassword, salt);
        if(!calcPass.equals(dbPass)) {
            return CodeMsg.PASSWORD_ERROR;
        }
        return CodeMsg.SUCCESS;
    }
}
