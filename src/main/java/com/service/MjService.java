package com.service;

import com.domain.MjBasic;
import com.domain.MjMore;
import com.dto.MjMoreDto;
import com.vo.MjLoginVo;
import com.vo.MjRegisterVo;

import javax.servlet.http.HttpServletResponse;

public interface MjService {

    /** 买家注册 */
    void register(MjRegisterVo vo);

    /** 买家登录 */
    String login(HttpServletResponse response, MjLoginVo vo);

    /** 添加买家详细信息 */
    void addMjDetailInfo(MjBasic mjBasic, MjMore mjMore);

    /** 获取买家详细信息 */
    MjMoreDto getMjDetail(MjBasic mjBasic);

    MjBasic getMjBasicByIdToken(HttpServletResponse response, String token);
}
