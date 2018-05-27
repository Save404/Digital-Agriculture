package com.dao;

import com.domain.MjBasic;
import com.vo.MjRegisterVo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.Data;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MjDaoTest {

    @Autowired
    MjDao mjDao;

//    @Test
//    @Transactional
//    public void register() {
//
//        MjBasic mjBasic = new MjBasic();
//        mjBasic.setMjId("0");
//        mjBasic.setMjTelephone("17367077253");
//        mjBasic.setMjPassword("123456");
//        mjBasic.setMjSalt("123");
//        int cnt =  mjDao.register(mjBasic);
//        Assert.assertEquals(1, cnt);
//    }

    @Test
    public void getMjBasicByTelephone() {
        String telephone = "17367077253";
        MjBasic mjBasic =  mjDao.getMjBasicByTelephone(telephone);
        Assert.assertEquals(telephone, mjBasic.getMjTelephone());
    }

}