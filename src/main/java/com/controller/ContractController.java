package com.controller;

import com.domain.Contract;
import com.github.pagehelper.PageInfo;
import com.result.Result;
import com.service.ContractService;
import io.swagger.annotations.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contracts")
@Api(description="签约模块")
public class ContractController {
    @Autowired
    ContractService contractService;

    @ApiOperation(value="创建合同")
    @ApiImplicitParam(name="contract", value="合同实体", required=true, dataType="Contract", paramType="query")
    @PostMapping()
    public Result<Boolean> createContract(@Valid Contract contract) {
        contractService.createContract(contract);
        return Result.success(true);
    }

    @ApiOperation(value = "获取合同")
    @ApiImplicitParam(name="id", value="合同id", required=true, dataType="String", paramType="path")
    @GetMapping("/{id}")
    public Result<Contract> getContract(@PathVariable("id") String id) {
        Contract contract = contractService.getContract(id);
        return Result.success(contract);
    }

    @ApiOperation(value = "修改合同状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="合同id", required=true, dataType="String", paramType="path"),
            @ApiImplicitParam(name="status", value="合同状态 可填项:agree, cancel, ship, finish", required=true,
                    dataType="String", paramType="query")
    })
    @PutMapping("/{id}/statu")
    public Result<Boolean> updateContractStatu(@PathVariable("id") String id,
                                               @RequestParam("status") String statu) {
        contractService.updateContractStatu(id, statu);
        return Result.success(true);
    }

    @ApiOperation(value = "卖家填写合同信息")
    @ApiImplicitParam(name="contract", value="合同实体, 填写项:contractId, salesName, alipayAccount, " +
            "purchasePrice, purchasesLiquidatedDamages, prePayment",required=true, dataType="Contract", paramType="query")
    @PutMapping
    public Result<Boolean> completeContract(Contract contract) {
        //TODO 参数校验
        contractService.completeContract(contract);
        return Result.success(true);
    }

    @ApiOperation(value = "更新支付状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="合同id", required=true, dataType="String", paramType="path"),
            @ApiImplicitParam(name="status", value="支付状态 可填项:finish", required=true,
                    dataType="String", paramType="query")
    })
    @PutMapping("/{id}/payStatu")
    public Result<Boolean> updatePayStatu(@PathVariable("id") String id, @RequestParam("status") String statu) {
        contractService.updatePayStatu(id, statu);
        return Result.success(true);
    }

    @ApiOperation(value = "获取合同列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="type", value="用户类型 可填nh、mj", required=true, dataType="String", paramType="query"),
            @ApiImplicitParam(name="id", value="用户id", required=true, dataType="String", paramType="query"),
            @ApiImplicitParam(name="currentPage", value="当前页", required=false, dataType="int", paramType="query"),
            @ApiImplicitParam(name="size", value="查询条数", required=false, dataType="int", paramType="query")
    })
    @GetMapping
    public Result<PageInfo<Contract>> getContractList(@RequestParam("type") String type,
                                                      @RequestParam("id") String id,
                                                      @RequestParam(name="currentPage", defaultValue="1", required=false) int currentPage,
                                                      @RequestParam(name="size", defaultValue="10", required=false) int size) {
        PageInfo<Contract> list = contractService.getContractList(type, id, currentPage, size);
        return Result.success(list);
    }
}
