package com.service;

import com.dao.NcpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NcpService {

    @Autowired
    NcpDao ncpDao;
}
