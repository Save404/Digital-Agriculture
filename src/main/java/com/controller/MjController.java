package com.controller;

import com.domain.MjBasic;
import com.domain.MjMore;
import com.dto.MjMoreDto;
import com.result.CodeMsg;
import com.result.Result;
import com.service.imp.MjService;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/mj")
public class MjController {

    @Autowired
    MjService mjService;

    @RequestMapping(value = "/get_mj_detail", method = RequestMethod.GET)
    @ResponseBody
    public Result<MjMoreDto> getMjDetail(MjBasic mjBasic) {
        if(null == mjBasic) {
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        MjMoreDto mjMoreDto = mjService.getMjDetail(mjBasic);
        if(null != mjMoreDto) {
            return Result.success(mjMoreDto);
        } else {
            return Result.error(null);
        }
    }

    @RequestMapping(value = "/add_mj_detail", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addMjDetail(@Valid MjMore mjMore, MjBasic mjBasic) {
        if(null == mjBasic) {
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        mjService.addMjDetailInfo(mjBasic, mjMore);
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

    @RequestMapping(value="/mj_login", method=RequestMethod.POST)
    @ResponseBody
    public Result<String> mjLogin(HttpServletResponse response, @Valid MjLoginVo vo) {
        String id = mjService.login(response, vo);
        return Result.success(id);
    }
}
