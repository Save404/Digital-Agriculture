package com.service.imp;

import com.common.commonUtils.StringUtils;
import com.common.commonUtils.UUIDUtil;
import com.dao.GovDao;
import com.dao.PermissionDao;
import com.domain.Gov;
import com.domain.Permission;
import com.dto.GovPmsnDto;
import com.exception.GlobalException;
import com.redis.RedisService;
import com.redis.key.GovKey;
import com.result.CodeMsg;
import com.service.GovService;
import com.vo.GovLoginVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class GovServiceImp implements GovService {

    public static final String COOKI_GOV_ID_TOKEN = "COOKI_GOV_ID_TOKEN";

    @Autowired
    RedisService redisService;

    @Autowired
    GovDao govDao;

    @Autowired
    PermissionDao permissionDao;

    @Override
    public String login(HttpServletResponse response, GovLoginVo vo) {
//        1. 根据账号在数据库查询政府人员的信息
        String account = vo.getGovId();
        String password = vo.getGovPassword();
        Gov gov = govDao.getGovByAccount(account);
        if (gov == null){
            throw new GlobalException(CodeMsg.NH_NOT_EXISTS);
        }

//        2. 比对密码（salt加密）
//        String saltPassword = MD5Util.formPassToDBPass(password, gov.getGovSalt());
//        if (saltPassword.equals(gov.getGovPassword()) == false){
//            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
//        }

//        2. 对比密码
        if (password.equals(gov.getGovPassword()) == false){
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }

//       3. 查询权限
        GovPmsnDto govPmsnDto = new GovPmsnDto();
        BeanUtils.copyProperties(gov, govPmsnDto);

        List<Permission>permissions = permissionDao.getPermissionsByGovAccount(account);
        govPmsnDto.setPermissions(permissions);

//        4. 添加cookie
        addCookie(response, govPmsnDto);

//        5. 返回govId
        return govPmsnDto.getGovId();
    }

    private void addCookie(HttpServletResponse response, GovPmsnDto govPmsnDto){
//        1. 验证传入数据是否为空
        if (response == null || govPmsnDto == null){
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
//        2. 存入redis
        String token = UUIDUtil.uuid();
        redisService.set(GovKey.token, token, govPmsnDto);
//        3. 设置cookie的相关属性
        Cookie cookie = new Cookie(COOKI_GOV_ID_TOKEN, token);
        cookie.setMaxAge(GovKey.token.expireSecond());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public GovPmsnDto getGovPmsnByIdToken(HttpServletResponse response, String token){
        if (StringUtils.isEmpty(token) || response == null){
            return null;
        }
        GovPmsnDto govPmsnDto = redisService.get(GovKey.token, token, GovPmsnDto.class);
        if (govPmsnDto != null){
            addCookie(response, govPmsnDto);
        }
        return govPmsnDto;
    }

}
