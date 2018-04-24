package com.doubles.service;

import java.util.List;

/**
 * @时间: 2018/4/23
 * @描述：
 */
public interface TransmitService {
    //转发
    Transmit addTransmit(Transmit transmit);
    //删除转发记录
    boolean deleteTransmit(String transmitId);
    //获取所有转发记录
    List<Transmit> findAll();
    
}
