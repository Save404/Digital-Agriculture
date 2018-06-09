package com.sql;

import com.domain.NcpBasic;
import com.domain.NcpMore;
import com.util.SqlProviderlUtil;
import com.util.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.*;


public class NcpSqlProvider {

    public String insertNcpBasicInfo(final NcpBasic ncpBasic)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("ncp_basic_id", ncpBasic.getNcpBasicId());
        map.put("ncp_name", ncpBasic.getNcpName());
        map.put("ncp_publish_date", ncpBasic.getNcpPublishDate());
        map.put("ncp_p_code", ncpBasic.getNcpPCode());
        map.put("ncp_area_code", ncpBasic.getNcpAreaCode());
        map.put("ncp_address", ncpBasic.getNcpAddress());
        map.put("nh_basic_id", ncpBasic.getNhBasicId());
        map.put("ncp_feature", ncpBasic.getNcpFeature());
        map.put("ncp_brand", ncpBasic.getNcpBrand());
        map.put("ncp_supply_amount", ncpBasic.getNcpSupplyAmount());
        map.put("supplyUnit", ncpBasic.getSupplyUnit());
        map.put("ncp_price", ncpBasic.getNcpPrice());
        map.put("price_unit", ncpBasic.getPriceUnit());
        map.put("ncp_status", ncpBasic.getNcpPrice());
        return SqlProviderlUtil.returnInsertSql("ncp_basic", map);

    }

    public String insertNcpMoreInfo(final NcpMore ncpMore)
    {
        Map<String, Object>map = new HashMap<String, Object>();
        map.put("ncp_more_id", ncpMore.getNcpMoreId());
        map.put("ncp_basic_id", ncpMore.getNcpBasicId());
        map.put("ncp_detail", ncpMore.getNcpDetail());
        map.put("ncp_package", ncpMore.getNcpPackage());
        map.put("ncp_quality", ncpMore.getNcpQuality());
        map.put("ncp_delivery_info", ncpMore.getNcpDeliveryInfo());
        map.put("ncp_growth_info", ncpMore.getNcpGrowthInfo());
        map.put("ncp_growth_surrounding", ncpMore.getNcpGrowthSurrounding());
        map.put("ncp_plant_area", ncpMore.getNcpPlantArea());
        map.put("plantUnit", ncpMore.getPlantUnit());
        map.put("ncp_supply_period_start", ncpMore.getNcpSupplyPeriodStart());
        map.put("ncp_delivery_ability", ncpMore.getNcpDeliveryAbility());
        map.put("ncp_supply_period_end", ncpMore.getNcpSupplyPeriodEnd());
        map.put("ncp_img", ncpMore.getNcpImg());
        return SqlProviderlUtil.returnInsertSql("ncp_more", map);
    }
}
