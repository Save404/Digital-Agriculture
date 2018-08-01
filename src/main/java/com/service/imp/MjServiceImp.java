package com.service.imp;

import com.dao.MjDao;
import com.domain.MjBasic;
import com.domain.MjMore;
import com.dto.MjMoreDto;
import com.exception.GlobalException;
import com.redis.key.MjKey;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.common.commonUtils.MD5Util;
import com.common.commonUtils.SaltUtil;
import com.common.commonUtils.StringUtils;
import com.common.commonUtils.UUIDUtil;
import com.service.MjService;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Service
public class MjServiceImp implements MjService {

    public static final String COOKI_MJ_ID_TOKEN = "COOKI_MJ_ID_TOKEN";

    @Autowired
    MjDao mjDao;

    @Autowired
    RedisService redisService;

    @Override
    public void register(MjRegisterVo vo) {
        String telephone = vo.getMjTelephone();
        //查询手机号是否已经注册
        MjBasic mj = mjDao.getMjBasicByTelephone(telephone);
        if(null != mj) {
            throw new GlobalException(CodeMsg.TELEPHONE_REPEAT);
        }
        MjBasic mjBasic = new MjBasic();
        mjBasic.setMjBasicId(UUIDUtil.uuid());
        mjBasic.setMjTelephone(telephone);
        String inputPass = vo.getMjPassword();
        String salt = SaltUtil.getSalt(8);
        String dbPass = MD5Util.inputPassToDBPass(inputPass, salt);
        mjBasic.setMjSalt(salt);
        mjBasic.setMjPassword(dbPass);
        int res = mjDao.register(mjBasic);
        if(res != 1) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
    }

    private MjBasic getMjBasicByTelephone(String telephone) {
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

    @Override
    public String login(HttpServletResponse response, MjLoginVo vo) {
        String mjTelephone = vo.getMjTelephone();
        String mjPassword = vo.getMjPassword();
        //判断用户是否存在
        MjBasic mjBasic = getMjBasicByTelephone(mjTelephone);
        if(null == mjBasic) {
            throw new GlobalException(CodeMsg.NH_NOT_EXISTS);
        }
        //验证密码
        String dbPass = mjBasic.getMjPassword();
        String salt = mjBasic.getMjSalt();
        String calcPass = MD5Util.formPassToDBPass(mjPassword, salt);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        addCookie(mjBasic, response);
        return mjBasic.getMjBasicId();
    }

    private void addCookie(MjBasic mjBasic, HttpServletResponse response) {
        String token = UUIDUtil.uuid();
        redisService.set(MjKey.token, token, mjBasic);
        Cookie cookie = new Cookie(COOKI_MJ_ID_TOKEN, token);
        cookie.setMaxAge(MjKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Transactional
    @Override
    public void addMjDetailInfo(MjBasic mjBasic, MjMore mjMore) {
        try {
            mjDao.deleteMoreByBasicId(mjBasic.getMjBasicId());
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        mjMore.setMjBasicId(mjBasic.getMjBasicId());
        mjMore.setMjMoreId(UUIDUtil.uuid());
        String inputPass = mjMore.getMjPayPassword();
        String salt = SaltUtil.getSalt(8);
        String dbPass = MD5Util.inputPassToDBPass(inputPass, salt);
        mjMore.setMjPayPassword(dbPass);
        mjMore.setMjPaySalt(salt);
        try {
            if(mjDao.addMjDetailInfo(mjMore) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
    }

    @Override
    public MjMoreDto getMjDetail(MjBasic mjBasic) {
        String mjBasicId = mjBasic.getMjBasicId();
        MjMoreDto mjMoreDto;
        try {
            mjMoreDto = mjDao.getMjMoreDtoByBasicId(mjBasicId);
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return mjMoreDto;
    }
}
