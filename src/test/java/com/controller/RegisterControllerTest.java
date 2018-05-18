package com.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class RegisterControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void mjRegister() throws  Exception{

        mvc.perform(MockMvcRequestBuilders.post("/register/mj_register")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("mjTelephone", "17367077254")
                .param("mjPassword", "123456")
                .param("rePassword", "123456"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}