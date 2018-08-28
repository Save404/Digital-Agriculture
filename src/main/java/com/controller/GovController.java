package com.controller;

import com.result.Result;
import com.service.GovService;
import com.vo.GovLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/gov")
public class GovController {

    @Autowired
    GovService govService;

    @PostMapping(value = "/login")
    @ResponseBody
    public Result<String> govLogin(HttpServletResponse response, @Valid GovLoginVo vo){
        String id  = govService.login(response, vo);
        return Result.success(id);
    }



}
