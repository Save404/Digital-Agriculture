package com.service;

import com.domain.NcpBasic;
import com.domain.NcpMore;
import com.domain.NhBasic;
import com.dto.NcpAllListDto;
import com.dto.NcpListDto;
import com.vo.NcpView;

import java.util.List;

public interface NcpService {

    /** 添加农产品信息 */
    void addNcpInfo(NcpBasic ncpBasic, NcpMore ncpMore);

    /** 农户获取产品列表 */
    List<NcpListDto> getNcpList(NhBasic nhBasic);

    /** 获取产品 */
    NcpView getNcpByNcpBasicId(String ncpBasicId);

    /** 修改产品 */
    void modifyNcp(String ncpBasicId, NcpBasic ncpBasic, NcpMore ncpMore);

    /** 买家获取产品列表 */
    List<NcpAllListDto> getMjAllNcpList();

    /** 删除产品 */
    void deleteNcp(String ncpBasicId);

    /** 上下架 */
    void onSell(String ncpBasicId);

    List<NcpAllListDto> getByProduct(String pCode);
}
