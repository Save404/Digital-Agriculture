package com.controller;

import com.result.CodeMsg;
import com.result.Result;
import com.service.NhService;
import com.util.StringUtils;
import com.util.ValidatorUtil;
import com.vo.NhLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    NhService nhService;

    @RequestMapping(value="/to_nh_login", method=RequestMethod.GET)
    public String toNhLogin() {
        return "index/nh_login";
    }

    @RequestMapping(value="/nh_login", method=RequestMethod.POST)
    @ResponseBody
    public Result<CodeMsg> nhRegister(NhLoginVo vo) {
        //参数校验
        if(null == vo) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        String nhTelephone = vo.getNhTelephone();
        String nhPassword = vo.getNhPassword();
        if(StringUtils.isEmpty(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(StringUtils.isEmpty(nhPassword)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        CodeMsg msg = nhService.login(vo);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }
}
