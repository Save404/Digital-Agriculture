package com.controller;

import com.domain.NcpBasic;
import com.domain.NcpMore;
import com.domain.NhBasic;
import com.result.CodeMsg;
import com.result.Result;
import com.service.NcpService;
import com.vo.NcpView;
import com.vo.NcpView1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/ncp")
public class NcpController {

    @Autowired
    NcpService ncpService;

    @RequestMapping("/add_ncp")
    @ResponseBody
    public Result<Boolean> addNcp(NhBasic nhBasic, @Valid NcpBasic ncpBasic, @Valid NcpMore ncpMore) {
        //登录检验
        if (nhBasic == null){
            return Result.error(CodeMsg.LOGIN_ERROR);
        }
        //数据传输检验
        if (ncpMore.getNcpSupplyPeriodStart() != null && ncpMore.getNcpSupplyPeriodEnd() != null){
            if(ncpMore.getNcpSupplyPeriodStart().getTime() > ncpMore.getNcpSupplyPeriodEnd().getTime()) {
                return Result.error(CodeMsg.NCP_SUPPLY_PERIOD_ERROR);
            }
        }
        //服务处理，返回结果
        ncpBasic.setNhBasicId(nhBasic.getNhBasicId());
        ncpService.addNcpInfo(ncpBasic, ncpMore);
        return Result.success(true);
    }

    @RequestMapping("/get_ncp_list")
    @ResponseBody
    public Result<List<NcpView1>> getNcpList(NhBasic nhBasic) {
        List<NcpView1> list = ncpService.getNcpList(nhBasic);
        return Result.success(list);
    }

    @RequestMapping("/get_ncp/{NcpBasicId}")
    @ResponseBody
    public Result<NcpView> getNcpByNcpBasicId(@PathVariable("NcpBasicId") String ncpBasicId) {
        NcpView ncpView = ncpService.getNcpByNcpBasicId(ncpBasicId);
        return Result.success(ncpView);
    }
}
