package com;

import com.service.imp.NcpServiceImp;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    NcpServiceImp ncpServiceImp;

//    @org.junit.Test
//    public void getAllNcpList() {
//        System.out.println(ncpService.getAllNcpList());
//    }

}
