package com.service;

import com.domain.MjBasic;
import com.result.CodeMsg;
import com.util.MD5Util;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MjServiceTest {

    @Autowired
    MjService mjService;

//    @Test
//    public void register() {
//        MjRegisterVo vo = new MjRegisterVo();
//        vo.setMjTelephone("17367077253");
//        vo.setMjPassword("123456");
//        vo.setRePassword("123456");
//        CodeMsg codeMsg =  mjService.register(vo);
//        Assert.assertEquals(0, codeMsg.getCode());
//    }

    @Test
    public void getMjBasicByTelephone(){
        String phone = "17367077253";
        MjBasic mjBasic =  mjService.getMjBasicByTelephone(phone);
        Assert.assertEquals(phone, mjBasic.getMjTelephone());
    }

//    @Test
//    public void login(){
//        MjLoginVo vo = new MjLoginVo();
//        vo.setMjTelephone("17367077253");
//        //String pwd = MD5Util.inputPassToFormPass("123456");
//        //vo.setMjPassword(pwd);
//        CodeMsg codeMsg = mjService.login(vo);
//        Assert.assertEquals(0, codeMsg.getCode());
//    }
}