package com.doubles.dao;

import com.doubles.entity.Transmit;
import com.doubles.entity.TransmitExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransmitMapper {
    int countByExample(TransmitExample example);

    int deleteByExample(TransmitExample example);

    int deleteByPrimaryKey(String transmitId);

    int insert(Transmit record);

    int insertSelective(Transmit record);

    List<Transmit> selectByExample(TransmitExample example);

    Transmit selectByPrimaryKey(String transmitId);

    int updateByExampleSelective(@Param("record") Transmit record, @Param("example") TransmitExample example);

    int updateByExample(@Param("record") Transmit record, @Param("example") TransmitExample example);

    int updateByPrimaryKeySelective(Transmit record);

    int updateByPrimaryKey(Transmit record);
}