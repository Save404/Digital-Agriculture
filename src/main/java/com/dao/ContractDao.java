package com.dao;

import com.domain.Contract;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ContractDao {

    int createContract(Contract contract);

    Contract getContract(@Param("id") String id);

    int updateContractStatu(@Param("id") String id, @Param("statu") Integer statu);

    int existById(@Param("id") String id);

    int completeContract(Contract contract);

    int updatePayStatu(@Param("id") String id, @Param("statu") Integer statu);

    //TODO 合并两个方法
    List<Contract> getNhContractList(@Param("id") String id);

    List<Contract> getMJContractList(@Param("id") String id);
}
