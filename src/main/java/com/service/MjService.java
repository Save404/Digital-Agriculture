package com.service;

import com.domain.MjBasic;
import com.domain.MjMore;
import com.dto.MjMoreDto;
<<<<<<< HEAD
=======
import com.exception.GlobalException;
import com.redis.key.MjKey;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.util.commonUtils.MD5Util;
import com.util.commonUtils.SaltUtil;
import com.util.commonUtils.StringUtils;
import com.util.commonUtils.UUIDUtil;
>>>>>>> origin/master
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;

import javax.servlet.http.HttpServletResponse;

public interface MjService {

    /** 买家注册 */
    void register(MjRegisterVo vo);

    /** 买家登录 */
    String login(HttpServletResponse response, MjLoginVo vo);

    /** 添加买家详细信息 */
    void addMjDetailInfo(MjBasic mjBasic, MjMore mjMore);

    /** 获取买家详细信息 */
    MjMoreDto getMjDetail(MjBasic mjBasic);

<<<<<<< HEAD
=======
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

    public String login(HttpServletResponse response, MjLoginVo vo) {
        if(null == response || null == vo) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
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

    public void addCookie(MjBasic mjBasic, HttpServletResponse response) {
        String token = UUIDUtil.uuid();
        redisService.set(MjKey.token, token, mjBasic);
        Cookie cookie = new Cookie(COOKI_MJ_ID_TOKEN, token);
        cookie.setMaxAge(MjKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public Boolean addMjDetailInfo(MjBasic mjBasic, MjMore mjMore) {
        if(null == mjMore || null == mjBasic) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
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
        return true;
    }

    public MjMoreDto getMjDetail(MjBasic mjBasic) {
        if(null == mjBasic) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mjBasicId = mjBasic.getMjBasicId();
        MjMoreDto mjMoreDto = null;
        try {
            mjMoreDto = mjDao.getMjMoreDtoByBasicId(mjBasicId);
            //需解析密码
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        if(null == mjMoreDto) {
            return null;
        } else {
            return mjMoreDto;
        }
    }
>>>>>>> origin/master
}
