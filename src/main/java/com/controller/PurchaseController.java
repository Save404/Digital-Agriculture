package com.controller;

import com.domain.Purchases;
import com.github.pagehelper.PageInfo;
import com.result.Result;
import com.service.PurchaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;



@RestController
@RequestMapping("/purchases")
@Api(description="求购信息模块")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @ApiOperation(value="发布求购信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="type", value="用户类型,填NH或MJ", required=true, dataType="String", paramType="query"),
            @ApiImplicitParam(name="purchases", value="purchases实体,上传basicId(用户id),title(标题),content(内容),telephone(手机号)",
                    required=true, dataType="Purchases", paramType="body")
    })
    @PostMapping
    public Result<Boolean> releaseRequirement(@RequestParam(value = "type") String type,
                                              @Valid Purchases purchases) {
        purchaseService.releaseRequirement(type, purchases);
        return Result.success(true);
    }

    @ApiOperation(value="删除求购信息", notes="根据url的id来获取求购信息的编号")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value ="求购信息的编号", required=true, dataType="String", paramType="path"),
            @ApiImplicitParam(name="type", value="用户类型,填NH或MJ", required=true, dataType="String", paramType="body")
    })
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteRequirement(@RequestParam(value = "type") String type,
                                             @PathVariable("id") String id) {
        purchaseService.deleteRequirement(id, type);
        return Result.success(true);
    }

    @ApiOperation(value="修改求购信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value ="求购信息的编号", required=true, dataType="String", paramType="path"),
            @ApiImplicitParam(name="type", value="用户类型,填NH或MJ", required=true, dataType="String", paramType="body"),
            @ApiImplicitParam(name="purchases", value="purchases实体,上传basicId(用户id),title(标题),content(内容),telephone(手机号)",
                    required=true, dataType="Purchases", paramType="body")
    })
    @PutMapping("/{id}")
    public Result<Boolean> updateRequirement(@RequestParam(value = "type") String type,
                                             @PathVariable("id") String id,
                                             @Valid Purchases purchases) {
        purchaseService.updateRequirement(id, type, purchases);
        return Result.success(true);
    }

    @ApiOperation(value="获取求购信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value ="求购信息的编号", required=true, dataType="String", paramType="path"),
            @ApiImplicitParam(name="type", value="用户类型,填NH或MJ", required=true, dataType="String", paramType="body")
    })
    @GetMapping("/{id}")
    public Result<Purchases> getPurchase(@RequestParam(value = "type") String type,
                                       @PathVariable String id) {
        Purchases purchases = purchaseService.getRequirement(type, id);
        return Result.success(purchases);
    }

    @ApiOperation(value="获取求购信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="type", value="用户类型,填NH或MJ", required=true, dataType="String", paramType="body"),
            @ApiImplicitParam(name="currentPage", value="当前页", required=false, dataType="int", paramType="body"),
            @ApiImplicitParam(name="limit", value="查询条数", required=false, dataType="int", paramType="body")
    })
    @GetMapping
    public Result<PageInfo<Purchases>> getPurchases(@RequestParam(value = "type") String type,
                                                    @RequestParam(value = "currentPage", required = false, defaultValue="1") int currentPage,
                                                    @RequestParam(value = "size", required = false, defaultValue="10") int size) {
        PageInfo<Purchases> list = purchaseService.getRequirementList(type, currentPage, size);
        return Result.success(list);
    }
}
