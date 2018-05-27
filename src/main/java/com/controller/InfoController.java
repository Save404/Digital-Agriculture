package com.controller;

import com.domain.NcpBasic;
import com.domain.NhBasic;
import com.domain.NhMore;
import com.result.CodeMsg;
import com.result.Result;
import com.service.NcpService;
import com.service.NhService;
import com.util.StringUtils;
import com.util.ValidatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    NhService nhService;

    @Autowired
    NcpService ncpService;

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
        if(StringUtils.isEmpty(realName)) {
            return Result.error(CodeMsg.NAME_EMPTY);
        }
        String idCard = nhMore.getNhIdCard();
        if(StringUtils.isEmpty(idCard)) {
            return Result.error(CodeMsg.ID_CARD_EMPTY);
        } else if(!ValidatorUtil.isIdCard(idCard)) {
            return Result.error(CodeMsg.ID_CARD_ERROR);
        }
        String ghdwAreaCode = nhMore.getNhGndwAreaCode();
        if(StringUtils.isEmpty(ghdwAreaCode)) {
            return Result.error(CodeMsg.GHDW_Area_Code);
        }
        String nhSex = nhMore.getNhSex();
        if(StringUtils.isEmpty(nhSex)) {
            return Result.error(CodeMsg.SEX_EMPTY);
        }
        String nhOrigin = nhMore.getNhOrigin();
        if(StringUtils.isEmpty(nhOrigin)) {
            return Result.error(CodeMsg.ORIGIN_EMPTY);
        }
        String nhNation = nhMore.getNhNation();
        if(StringUtils.isEmpty(nhNation)) {
            return Result.error(CodeMsg.NATION_EMPTY);
        }
        CodeMsg msg = nhService.addNhDetailInfo(nhBasic, nhMore);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        }
        else {
            return Result.error(msg);
        }
    }

//    @RequestMapping("/add_ncp_basic")
//    @ResponseBody
//    public Result<CodeMsg> addNcpBasic(NhBasic nhBasic, NcpBasic ncpBasic) {
//
//    }
}
