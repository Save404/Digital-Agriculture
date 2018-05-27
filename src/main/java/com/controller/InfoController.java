package com.controller;

import com.domain.NcpBasic;
import com.domain.NcpMore;
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
import redis.clients.jedis.JedisCluster;

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

    @RequestMapping("/add_ncp")
    @ResponseBody
    public Result<CodeMsg> addNcp(NhBasic nhBasic, NcpBasic ncpBasic, NcpMore ncpMore) {

        //登录检验
        if (nhBasic == null){
            return Result.error(CodeMsg.LOGIN_ERROR);
        }

        //数据传输检验
        if (ncpBasic == null || ncpMore == null){
            return Result.error(CodeMsg.BIND_ERROR);
        }

        //传入参数检验
        if (StringUtils.isEmpty(ncpBasic.getNcpName())){
            return Result.error(CodeMsg.NCP_NAME_EMPTY);
        }
        if (StringUtils.isEmpty(ncpBasic.getNcpPCode())){
            return Result.error(CodeMsg.NCP_P_CODE);
        }
        if (StringUtils.isEmpty(ncpBasic.getNcpAreaCode())){
            return Result.error(CodeMsg.NCP_AREA_CODE);
        }
        if (StringUtils.isEmpty(ncpBasic.getNcpAddress())){
            return Result.error(CodeMsg.NCP_ADDRESS_EMPTY);
        }
        if (StringUtils.isEmpty(ncpBasic.getNcpFeature())) {
            return Result.error(CodeMsg.NCP_FEATURE_EMPTY);
        }
        if (ncpMore.getNcpSupplyPeriodStart() != null && ncpMore.getNcpSupplyPeriodEnd() != null
                &&  ncpMore.getNcpSupplyPeriodStart().getTime() > ncpMore.getNcpSupplyPeriodEnd().getTime()){
            return Result.error(CodeMsg.NCP_SUPPLY_PERIOD_ERROR);
        }

        //服务处理，返回结果
        ncpBasic.setNhBasicId(nhBasic.getNhBasicId());
        CodeMsg res =  ncpService.addNcpInfo(ncpBasic, ncpMore);
        if (res.getCode() == 0){
            return Result.success(res);
        }
        else {
            return Result.error(res);
        }
    }
}
