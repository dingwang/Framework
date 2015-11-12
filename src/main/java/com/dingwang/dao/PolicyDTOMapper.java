package com.dingwang.dao;

import com.dingwang.model.PolicyDTO;
import com.dingwang.model.PolicyDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PolicyDTOMapper {
    int countByExample(PolicyDTOExample example);

    int deleteByExample(PolicyDTOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PolicyDTO record);

    int insertSelective(PolicyDTO record);

    List<PolicyDTO> selectByExample(PolicyDTOExample example);

    PolicyDTO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PolicyDTO record, @Param("example") PolicyDTOExample example);

    int updateByExample(@Param("record") PolicyDTO record, @Param("example") PolicyDTOExample example);

    int updateByPrimaryKeySelective(PolicyDTO record);

    int updateByPrimaryKey(PolicyDTO record);
}