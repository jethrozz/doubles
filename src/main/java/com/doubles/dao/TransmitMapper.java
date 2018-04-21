package com.doubles.dao;

import com.doubles.entity.Transmit;
import com.doubles.entity.TransmitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransmitMapper {
    long countByExample(TransmitExample example);

    int deleteByExample(TransmitExample example);

    int deleteByPrimaryKey(String transmit_id);

    int insert(Transmit record);

    int insertSelective(Transmit record);

    List<Transmit> selectByExample(TransmitExample example);

    Transmit selectByPrimaryKey(String transmit_id);

    int updateByExampleSelective(@Param("record") Transmit record, @Param("example") TransmitExample example);

    int updateByExample(@Param("record") Transmit record, @Param("example") TransmitExample example);

    int updateByPrimaryKeySelective(Transmit record);

    int updateByPrimaryKey(Transmit record);
}