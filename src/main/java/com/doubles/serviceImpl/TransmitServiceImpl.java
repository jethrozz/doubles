package com.doubles.serviceImpl;

import com.doubles.dao.TransmitDao;
import com.doubles.entity.Transmit;
import com.doubles.service.TransmitService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 转发表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class TransmitServiceImpl extends ServiceImpl<TransmitDao, Transmit> implements TransmitService {

}
