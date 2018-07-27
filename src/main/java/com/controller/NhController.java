package com.controller;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
import com.result.CodeMsg;
import com.result.Result;
import com.service.imp.NhService;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/nh")
public class NhController {

    @Autowired
    NhService nhService;

    @RequestMapping("/add_nh_detail")
    @ResponseBody
    public Result<Boolean> addNhDetailInfo(NhBasic nhBasic, @Valid NhMore nhMore) {
        if(null == nhBasic) {
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        nhService.addNhDetailInfo(nhBasic, nhMore);
        return Result.success(true);
    }

    @RequestMapping(value = "/get_nh_detail", method = RequestMethod.GET)
    @ResponseBody
    public Result<NhMoreDto> getNhDetail(NhBasic nhBasic) {
        if(null == nhBasic) {
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        NhMoreDto nhMoreDto = nhService.getNhDetail(nhBasic);
        if(null != nhMoreDto) {
            return Result.success(nhMoreDto);
        } else {
            return Result.error(null);
        }
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

    @RequestMapping(value="/nh_login", method=RequestMethod.POST)
    @ResponseBody
    public Result<String> nhLogin(HttpServletResponse response, @Valid NhLoginVo vo) {
        String id = nhService.login(response, vo);
        return Result.success(id);
    }
}
