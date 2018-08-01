package com.sql;

import com.domain.NhMore;
import com.common.SqlProviderlUtil;


import java.util.HashMap;
import java.util.Map;

public class NhSqlProvider {
    public String insertNhDetailInfo(final NhMore nhMore) {
        Map<String, Object>map = new HashMap<String, Object>();
        map.put("nh_more_id", nhMore.getNhMoreId());
        map.put("nh_basic_id", nhMore.getNhBasicId());
        map.put("nh_real_name", nhMore.getNhRealName());
        map.put("nh_id_card", nhMore.getNhIdCard());
        map.put("nh_ghdw_address", nhMore.getNhGhdwAddress());
        map.put("nh_ghdw_area_code", nhMore.getNhGhdwAreaCode());
        map.put("nh_ghdw_phone", nhMore.getNhGhdwPhone());
        map.put("nh_pay_password", nhMore.getNhPayPassword());
        map.put("nh_pay_salt", nhMore.getNhPaySalt());
        map.put("nh_status", nhMore.getNhStatus());
        map.put("nh_sex", nhMore.getNhSex());
        map.put("nh_origin", nhMore.getNhOrigin());
        map.put("nh_nation", nhMore.getNhNation());
        map.put("nh_politics", nhMore.getNhPolitics());
        return SqlProviderlUtil.returnInsertSql("nh_more", map);
    }
}
