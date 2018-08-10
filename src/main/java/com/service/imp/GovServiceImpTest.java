package com.service.imp;

import com.common.commonUtils.MD5Util;
import com.dto.GovPmsnDto;
import com.redis.RedisService;
import com.redis.key.GovKey;
import com.service.GovService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class GovServiceImpTest {

    @Autowired
    GovService service;

    @Autowired
    RedisService redisService;

    @Test
    public void salt(){
        String salt = "kerisyps";
        String password = "17367077253";
        String saltPassword = MD5Util.formPassToDBPass(password, salt);
        System.out.println("saltPassword: " + saltPassword);
    }

    @Test
    public void token(){
        String token = "24bae8960b0e489d85428376cd2b1465";
        GovPmsnDto govPmsnDto = redisService.get(GovKey.token, token, GovPmsnDto.class);
        log.info(govPmsnDto.toString());
        Assert.assertNotNull(govPmsnDto);
    }
}