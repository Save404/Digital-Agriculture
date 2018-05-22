package com.controller;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.result.CodeMsg;
import com.result.Result;
import com.service.NhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    NhService nhService;

    @RequestMapping("/add_nh_detail")
    @ResponseBody
    public Result<CodeMsg> addNhDetailInfo(NhBasic nhBasic, NhMore nhMore) {
        if(null == nhBasic) {
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        if(null == nhMore) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        //参数校验
        String realName = nhMore.getNhRealName();
        String idCard = nhMore.getNhIdCard();
        String ghdwAreaCode = nhMore.getNhGndwAreaCode();
        String nhSex = nhMore.getNhSex();
        String nhOrigin = nhMore.getNhOrigin();
        String nhNation = nhMore.getNhNation();
        CodeMsg msg = nhService.addNhDetailInfo(nhBasic, nhMore);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        }
        else {
            return Result.error(msg);
        }
    }
}
