package com.service;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
<<<<<<< HEAD
=======
import com.exception.GlobalException;
import com.redis.key.NhKey;
import com.redis.RedisService;
import com.result.CodeMsg;
import com.util.commonUtils.MD5Util;
import com.util.commonUtils.SaltUtil;
import com.util.commonUtils.StringUtils;
import com.util.commonUtils.UUIDUtil;
>>>>>>> origin/master
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

public interface NhService {

    /** 农户注册 */
    void register(NhRegisterVo vo);

    /** 根据手机号码获取农户基本信息 */
    NhBasic getNhBasicByTelephone(String telephone);

    /** 农户登录 */
    String login(HttpServletResponse response, NhLoginVo vo);

    /** 添加农户详细信息 */
    void addNhDetailInfo(NhBasic nhBasic, NhMore nhMore);

    /** 获取农户详细信息 */
    NhMoreDto getNhDetail(NhBasic nhBasic);

<<<<<<< HEAD
    /** 判断用户是否存在 */
    Boolean existByBasicId(String id);
=======
    public NhBasic getNhBasicById(String nhBasicId) {
        return nhDao.getNhBasicById(nhBasicId);
    }

    public NhBasic getNhBasicByIdToken(HttpServletResponse response, String token) {
        if(StringUtils.isEmpty(token) || null ==response) {
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

    public String login(HttpServletResponse response, NhLoginVo vo) {
        if(null == response || null == vo) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String nhTelephone = vo.getNhTelephone();
        String nhPassword = vo.getNhPassword();
        //判断用户是否存在
        NhBasic nhBasic = getNhBasicByTelephone(nhTelephone);
        if(null == nhBasic) {
            throw new GlobalException(CodeMsg.NH_NOT_EXISTS);
        }
        //验证密码
        String dbPass = nhBasic.getNhPassword();
        String salt = nhBasic.getNhSalt();
        String calcPass = MD5Util.formPassToDBPass(nhPassword, salt);
        if(!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成cookie
        addCookie(nhBasic, response);
        return nhBasic.getNhBasicId();
    }

    public void addCookie(NhBasic nhBasic, HttpServletResponse response) {
        if(null == nhBasic || null == response) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String token = UUIDUtil.uuid();
        redisService.set(NhKey.token, token, nhBasic);
        Cookie cookie = new Cookie(COOKI_NH_ID_TOKEN, token);
        cookie.setMaxAge(NhKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Transactional
    public Boolean addNhDetailInfo(NhBasic nhBasic, NhMore nhMore) {
        if(null == nhMore || null == nhBasic) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        try {
            nhDao.deleteMoreByBasicId(nhBasic.getNhBasicId());
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        nhMore.setNhBasicId(nhBasic.getNhBasicId());
        nhMore.setNhMoreId(UUIDUtil.uuid());
        String inputPass = nhMore.getNhPayPassword();
        String salt = SaltUtil.getSalt(8);
        String dbPass = MD5Util.inputPassToDBPass(inputPass, salt);
        nhMore.setNhPayPassword(dbPass);
        nhMore.setNhPaySalt(salt);
        try {
            if(nhDao.addNhDetailInfo(nhMore) != 1) {
                throw new GlobalException(CodeMsg.SERVER_ERROR);
            }
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        return true;
    }

    public NhMoreDto getNhDetail(NhBasic nhBasic) {
        if(null == nhBasic) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String nhBasicId = nhBasic.getNhBasicId();
        NhMoreDto nhMoreDto = null;
        try {
            nhMoreDto = nhDao.getNhMoreDtoByBasicId(nhBasicId);
            //需解析密码
        } catch (Exception e) {
            throw new GlobalException(CodeMsg.DB_ERROR);
        }
        if(null == nhMoreDto) {
            return null;
        } else {
            return nhMoreDto;
        }
    }
>>>>>>> origin/master
}
