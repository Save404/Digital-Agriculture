package com.sql;

import com.domain.MjMore;
import com.common.SqlProviderlUtil;

import java.util.HashMap;
import java.util.Map;

public class MjSqlProvider {

    public String insertMjDetailInfo(final MjMore mjMore) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("mj_more_id", mjMore.getMjMoreId());
        map.put("mj_basic_id", mjMore.getMjBasicId());
        map.put("mj_real_name", mjMore.getMjRealName());
        map.put("mj_id_card", mjMore.getMjIdCard());
        map.put("mj_sex", mjMore.getMjSex());
        map.put("mj_pay_password", mjMore.getMjPayPassword());
        map.put("mj_pay_salt", mjMore.getMjPaySalt());
        map.put("mj_a_code", mjMore.getMjACode());
        map.put("mj_status", mjMore.getMjStatus());
        map.put("mj_origin", mjMore.getMjOrigin());
        map.put("mj_nation", mjMore.getMjNation());
        map.put("mj_politics", mjMore.getMjPolitics());
        return SqlProviderlUtil.returnInsertSql("mj_more", map);
    }
}
