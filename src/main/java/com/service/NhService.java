package com.service;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

public interface NhService {

    /** 农户注册 */
    Boolean register(NhRegisterVo vo);

    /** 根据手机号码获取农户基本信息 */
    NhBasic getNhBasicByTelephone(String telephone);

    /** 根据id获取农户基本信息 */
    NhBasic getNhBasicById(String nhBasicId);

    /** 农户登录 */
    String login(HttpServletResponse response, NhLoginVo vo);

    /** 添加农户详细信息 */
    Boolean addNhDetailInfo(NhBasic nhBasic, NhMore nhMore);

    /** 获取农户详细信息 */
    NhMoreDto getNhDetail(NhBasic nhBasic);

    /** 判断用户是否存在 */
    Boolean existByBasicId(String id);
}
