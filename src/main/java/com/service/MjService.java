package com.service;

import com.dao.MjDao;
import com.domain.MjBasic;
import com.redis.MjKey;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.util.MD5Util;
import com.util.SaltUtil;
import com.util.StringUtils;
import com.util.UUIDUtil;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class MjService {

    public static final String COOKI_MJ_ID_TOKEN = "COOKI_MJ_ID_TOKEN";

    @Autowired
    MjDao mjDao;

    @Autowired
    RedisService redisService;

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

    public MjBasic getMjBasicByIdToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        MjBasic mjBasic = redisService.get(MjKey.token, token, MjBasic.class);
        //延长有效期
        if(null == mjBasic) {
            return null;
        } else {
            addCookie(mjBasic, response);
        }
        return mjBasic;
    }

    public CodeMsg login(HttpServletResponse response, MjLoginVo vo) {
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
        //生成cookie
        addCookie(mjBasic, response);
        return CodeMsg.SUCCESS;
    }

    public void addCookie(MjBasic mjBasic, HttpServletResponse response) {
        String token = UUIDUtil.uuid();
        redisService.set(MjKey.token, token, mjBasic);
        Cookie cookie = new Cookie(COOKI_MJ_ID_TOKEN, token);
        cookie.setMaxAge(MjKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}