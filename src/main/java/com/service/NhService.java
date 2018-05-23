package com.service;

import com.dao.NhDao;
import com.domain.NhBasic;
import com.domain.NhMore;
import com.redis.NhKey;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.util.MD5Util;
import com.util.SaltUtil;
import com.util.StringUtils;
import com.util.UUIDUtil;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Service
public class NhService {

    public static final String COOKI_NH_ID_TOKEN = "COOKI_NH_ID_TOKEN";

    @Autowired
    NhDao nhDao;

    @Autowired
    RedisService redisService;

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
        nhBasic.setNhBasicId(UUID.randomUUID().toString());
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

    public NhBasic getNhBasicByIdToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token)) {
            return null;
        }
        NhBasic nhBasic = redisService.get(NhKey.token, token, NhBasic.class);
        //延长有效期
        if(null == nhBasic) {
            return null;
        } else {
            addCookie(nhBasic, response);
        }
        return nhBasic;
    }

    public CodeMsg login(HttpServletResponse response, NhLoginVo vo) {
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
        //生成cookie
        addCookie(nhBasic, response);
        return CodeMsg.SUCCESS;
    }

    public void addCookie(NhBasic nhBasic, HttpServletResponse response) {
        String token = UUIDUtil.uuid();
        redisService.set(NhKey.token, token, nhBasic);
        Cookie cookie = new Cookie(COOKI_NH_ID_TOKEN, token);
        cookie.setMaxAge(NhKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public CodeMsg addNhDetailInfo(NhBasic nhBasic, NhMore nhMore) {
        String nhTelephone = nhBasic.getNhTelephone();
        if(null == getNhBasicByTelephone(nhTelephone)) {
            return CodeMsg.NH_NOT_EXISTS;
        }
        nhMore.setNhBasicId(nhBasic.getNhBasicId());
        nhMore.setNhMoreId(UUID.randomUUID().toString());
        return nhDao.addNhDetailInfo(nhMore) == 1 ? CodeMsg.SUCCESS : CodeMsg.SERVER_ERROR;
    }
}
