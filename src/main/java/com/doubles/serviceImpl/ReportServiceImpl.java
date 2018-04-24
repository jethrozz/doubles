package com.doubles.serviceImpl;

import com.doubles.dao.ReportDao;
import com.doubles.entity.Report;
import com.doubles.service.ReportService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 举报表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportDao, Report> implements ReportService {

}
