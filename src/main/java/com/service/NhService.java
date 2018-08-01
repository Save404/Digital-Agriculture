package com.service;

import com.domain.NhBasic;
import com.domain.NhMore;
import com.dto.NhMoreDto;
import com.vo.NhLoginVo;
import com.vo.NhRegisterVo;

import javax.servlet.http.HttpServletResponse;

public interface NhService {

    /** 农户注册 */
    void register(NhRegisterVo vo);

    /** 根据手机号码获取农户基本信息 */
    NhBasic getNhBasicByTelephone(String telephone);

    /** 农户登录 */
    String login(HttpServletResponse response, NhLoginVo vo);

    /** 添加农户详细信息 */
    void addNhDetailInfo(NhBasic nhBasic, NhMore nhMore);

    /** 获取农户详细信息 */
    NhMoreDto getNhDetail(NhBasic nhBasic);

    Boolean existByBasicId(String id);
}
