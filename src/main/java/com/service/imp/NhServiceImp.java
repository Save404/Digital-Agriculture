package com.service.imp;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
import com.service.NhService;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class NhServiceImp implements NhService {
    @Override
    public Boolean register(NhRegisterVo vo) {
        return null;
    }

    @Override
    public NhBasic getNhBasicByTelephone(String telephone) {
        return null;
    }

    @Override
    public NhBasic getNhBasicById(String nhBasicId) {
        return null;
    }

    @Override
    public String login(HttpServletResponse response, NhLoginVo vo) {
        return null;
    }

    @Override
    public Boolean addNhDetailInfo(NhBasic nhBasic, NhMore nhMore) {
        return null;
    }

    @Override
    public NhMoreDto getNhDetail(NhBasic nhBasic) {
        return null;
    }

    @Override
    public Boolean existByBasicId(String id) {
        return null;
    }
}
