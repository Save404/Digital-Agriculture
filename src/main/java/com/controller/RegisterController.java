package com.controller;

import com.exception.GlobalException;
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

import javax.validation.Valid;

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
    public Result<Boolean> nhRegister(@Valid NhRegisterVo vo) {
        String nhPassword = vo.getNhPassword();
        String rePassword = vo.getRePassword();
        if(!nhPassword.equals(rePassword)) {
            return Result.error(CodeMsg.REPASSWORD_ERROR);
        }
        //注册
        nhService.register(vo);
        return Result.success(true);
    }

    @RequestMapping(value="/mj_register", method=RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> mjRegister(@Valid MjRegisterVo vo) {
        String mjPassword = vo.getMjPassword();
        String rePassword = vo.getRePassword();
        if(!mjPassword.equals(rePassword)) {
            return Result.error(CodeMsg.REPASSWORD_ERROR);
        }
        //注册
        mjService.register(vo);
        return Result.success(true);
    }
}
