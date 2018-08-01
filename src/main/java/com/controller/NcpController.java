package com.controller;

import com.domain.NcpBasic;
import com.domain.NcpMore;
import com.domain.NhBasic;
import com.dto.NcpAllListDto;
import com.dto.NcpListDto;
import com.result.CodeMsg;
import com.result.Result;
import com.service.NcpService;
import com.vo.NcpView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/get_mj_all_ncp_list", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<NcpAllListDto>> getMjAllNcpList() {
        List<NcpAllListDto> list = ncpService.getMjAllNcpList();
        return Result.success(list);
    }

    @RequestMapping(value = "/on_sell/{NcpBasicId}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> onSell(@PathVariable("NcpBasicId") String ncpBasicId) {
        ncpService.onSell(ncpBasicId);
        return Result.success(true);
    }

    @RequestMapping(value = "/getByProduct/{pCode}", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<NcpAllListDto>> getByProduct(@PathVariable("pCode") String pCode) {
        List<NcpAllListDto> list = ncpService.getByProduct(pCode);
        return Result.success(list);
    }

    @RequestMapping(value = "/get_ncp_list", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<NcpListDto>> getNcpList(NhBasic nhBasic) {
        List<NcpListDto> list = ncpService.getNcpList(nhBasic);
        return Result.success(list);
    }

    @RequestMapping(value = "/delete_ncp/{NcpBasicId}", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> deleteNcp(@PathVariable("NcpBasicId") String ncpBasicId) {
        ncpService.deleteNcp(ncpBasicId);
        return Result.success(true);
    }

    @RequestMapping(value = "/get_ncp/{NcpBasicId}", method = RequestMethod.GET)
    @ResponseBody
    public Result<NcpView> getNcpByNcpBasicId(@PathVariable("NcpBasicId") String ncpBasicId) {
        NcpView ncpView = ncpService.getNcpByNcpBasicId(ncpBasicId);
        return Result.success(ncpView);
    }

    @RequestMapping("/modify_ncp/{NcpBasicId}")
    @ResponseBody
    public Result<Boolean> modifyNcp(@PathVariable("NcpBasicId") String ncpBasicId,NhBasic nhBasic,
                                     @Valid NcpBasic ncpBasic, @Valid NcpMore ncpMore) {
        if (ncpMore.getNcpSupplyPeriodStart() != null && ncpMore.getNcpSupplyPeriodEnd() != null){
            if(ncpMore.getNcpSupplyPeriodStart().getTime() > ncpMore.getNcpSupplyPeriodEnd().getTime()) {
                return Result.error(CodeMsg.NCP_SUPPLY_PERIOD_ERROR);
            }
        }
        ncpBasic.setNhBasicId(nhBasic.getNhBasicId());
        ncpService.modifyNcp(ncpBasicId, ncpBasic, ncpMore);
        return Result.success(true);
    }
}
