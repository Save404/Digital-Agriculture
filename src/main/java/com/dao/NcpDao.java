package com.dao;

import com.domain.NcpBasic;
import com.domain.NcpMore;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NcpDao {

    @InsertProvider(type=com.sql.NcpSqlProvider.class, method = "insertNcpBasicInfo")
    public int addNcpBasicInfo(NcpBasic ncpBasic);

    @InsertProvider(type=com.sql.NcpSqlProvider.class, method="insertNcpMoreInfo")
    public int addNcpMoreInfo(NcpMore ncpMore);
}
