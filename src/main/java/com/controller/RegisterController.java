package com.controller;

import com.result.CodeMsg;
import com.result.Result;
import com.service.MjService;
import com.service.NhService;
import com.util.StringUtils;
import com.util.ValidatorUtil;
import com.vo.MjRegisterVo;
import com.vo.NhRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    NhService nhService;

    @Autowired
    MjService mjService;

    @RequestMapping(value="/to_nh_register", method=RequestMethod.GET)
    public String toNhRegister() {
        return "index/nh_register";
    }

    @RequestMapping(value="/to_mj_register", method=RequestMethod.GET)
    public String toMjRegister() {
        return "index/mj_register";
    }

    @RequestMapping(value="/nh_register", method=RequestMethod.POST)
    @ResponseBody
    public Result<CodeMsg> nhRegister(NhRegisterVo vo) {
        //参数校验
        if(null == vo) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        String nhTelephone = vo.getNhTelephone();
        String nhPassword = vo.getNhPassword();
        String rePassword = vo.getRePassword();
        if(StringUtils.isEmpty(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(StringUtils.isEmpty(nhPassword)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        if(StringUtils.isEmpty(rePassword) || !nhPassword.equals(rePassword)) {
            return Result.error(CodeMsg.REPASSWORD_ERROR);
        }
        //注册
        CodeMsg msg = nhService.register(vo);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }


    @RequestMapping(value="/mj_register", method=RequestMethod.POST)
    @ResponseBody
    public Result<CodeMsg> mjRegister(MjRegisterVo vo) {
        //参数校验
        if(null == vo) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        String mjTelephone = vo.getMjTelephone();
        String mjPassword = vo.getMjPassword();
        String rePassword = vo.getRePassword();
        if(StringUtils.isEmpty(mjTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(StringUtils.isEmpty(mjPassword)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(mjTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        if(StringUtils.isEmpty(rePassword) || !mjPassword.equals(rePassword)) {
            return Result.error(CodeMsg.REPASSWORD_ERROR);
        }
        //注册
        CodeMsg msg = mjService.register(vo);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }
}
