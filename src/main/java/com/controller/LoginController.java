package com.controller;

import com.domain.NhBasic;
import com.result.CodeMsg;
import com.result.Result;
import com.service.MjService;
import com.service.NhService;
import com.util.StringUtils;
import com.util.ValidatorUtil;
import com.vo.MjLoginVo;
import com.vo.NhLoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    NhService nhService;
    
    @Autowired
    MjService mjService;

    @RequestMapping(value="/to_nh_login", method=RequestMethod.GET)
    public String toNhLogin() {
        return "index/nh_login";
    }

    @RequestMapping(value="/nh_login", method=RequestMethod.POST)
    @ResponseBody
    public Result<CodeMsg> nhRegister(HttpServletResponse response, NhLoginVo vo) {
        //参数校验
        if(null == vo) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        String nhTelephone = vo.getNhTelephone();
        String nhPassword = vo.getNhPassword();
        if(StringUtils.isEmpty(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(StringUtils.isEmpty(nhPassword)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(nhTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        CodeMsg msg = nhService.login(response, vo);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }
//
//    @RequestMapping(value="/nh_login", method=RequestMethod.POST)
//    @ResponseBody
//    public Result<CodeMsg> nhRegister(HttpServletResponse response, @RequestBody Map map) {
//        //参数校验
////        if(null == vo) {
////            return Result.error(CodeMsg.BIND_ERROR);
////        }
////        String nhTelephone = vo.getNhTelephone();
////        String nhPassword = vo.getNhPassword();
//        String nhTelephone = map.get("nhTelephone").toString();
//        String nhPassword = map.get("nhPassword").toString();
//        NhLoginVo nhLoginVo = new NhLoginVo();
//        nhLoginVo.setNhTelephone(nhTelephone);
//        nhLoginVo.setNhPassword(nhPassword);
//        if(StringUtils.isEmpty(nhTelephone)) {
//            return Result.error(CodeMsg.TELEPHONE_EMPTY);
//        }
//        if(StringUtils.isEmpty(nhPassword)) {
//            return Result.error(CodeMsg.PASSWORD_EMPTY);
//        }
//        if(!ValidatorUtil.isTelephone(nhTelephone)) {
//            return Result.error(CodeMsg.TELEPHONE_ERROR);
//        }
//        CodeMsg msg = nhService.login(response, nhLoginVo);
//        if(msg.getCode() == 0) {
//            return Result.success(msg);
//        } else {
//            return Result.error(msg);
//        }
//    }

    @RequestMapping(value="/to_mj_login", method=RequestMethod.GET)
    public String toMjLogin() {
        return "index/mj_login";
    }

    @RequestMapping(value="/mj_login", method=RequestMethod.POST)
    @ResponseBody
    public Result<CodeMsg> mjRegister(HttpServletResponse response, MjLoginVo vo) {
        //参数校验
        if(null == vo) {
            return Result.error(CodeMsg.BIND_ERROR);
        }
        String mjTelephone = vo.getMjTelephone();
        String mjPassword = vo.getMjPassword();
        if(StringUtils.isEmpty(mjTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_EMPTY);
        }
        if(StringUtils.isEmpty(mjPassword)) {
            return Result.error(CodeMsg.PASSWORD_EMPTY);
        }
        if(!ValidatorUtil.isTelephone(mjTelephone)) {
            return Result.error(CodeMsg.TELEPHONE_ERROR);
        }
        CodeMsg msg = mjService.login(response, vo);
        if(msg.getCode() == 0) {
            return Result.success(msg);
        } else {
            return Result.error(msg);
        }
    }
}
