package com.dao;

import com.domain.NhBasic;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NhDaoTest {

    @Autowired
    private NhDao nhDao;

    @Test
    public void register() {

    }

    @Test
    public void getNhBasicByTelephone() {
        NhBasic nhBasic = nhDao.getNhBasicByTelephone("17367077253");
        Assert.assertEquals("17367077253",nhBasic.getNhTelephone());

        nhBasic = nhDao.getNhBasicByTelephone("17367077254");
        Assert.assertEquals(null, nhBasic);

    }
}