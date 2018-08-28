package com.controller;

import com.domain.Notice;
import com.dto.GovPmsnDto;
import com.github.pagehelper.PageInfo;
import com.result.Result;
import com.service.NoticeService;
import com.vo.NoticeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @PostMapping(value = "/add")
    @ResponseBody
    public Result<Boolean> addNotice(GovPmsnDto gov, Notice notice){
        Boolean res = noticeService.addNotice(gov, notice);
        return Result.success(res);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Result<Boolean> deleteNotice(GovPmsnDto gov, @PathVariable("id") String id){
        boolean res = noticeService.deleteNotice(gov, id);
        return Result.success(res);
    }

    @PutMapping(value = "/update/{id}")
    @ResponseBody
    public Result<Boolean> updateNotice(GovPmsnDto gov,
                                        @PathVariable("id") String id,
                                        Notice notice){
        boolean res = noticeService.updateNotice(gov, id, notice);
        return Result.success(res);
    }

    @GetMapping(value = "/content/{id}")
    @ResponseBody
    public Result<NoticeView> getDetailNotice(@PathVariable("id") String id){
        NoticeView noticeView = noticeService.getDetailNotice(id);
        return Result.success(noticeView);
    }

    @GetMapping(value = "/list")
    @ResponseBody
    public Result<PageInfo<NoticeView>> getNoticeList(@RequestParam(value = "type") String type,
                                                    @RequestParam(value = "id", required = false) String id,
                                                    @RequestParam(value = "currentPage", required = false, defaultValue="1") int currentPage,
                                                    @RequestParam(value = "size", required = false, defaultValue="10") int size) {
        PageInfo<NoticeView> list = noticeService.getNoticeList(type, id, currentPage, size);
        return Result.success(list);
    }

}
