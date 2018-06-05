package com.controller;

import com.domain.Goods;
import com.domain.NhBasic;
import com.result.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/goods")
public class GoodsController {

    @RequestMapping("/add_goods")
    public Result<Boolean> addGoods(@Valid Goods goods, NhBasic nhBasic) {
        return Result.success(true);
    }
}
