package com.doubles.service;


import com.doubles.entity.Transmit;

import java.util.List;

/**
 * <p>
 * 转发表 服务类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
public interface TransmitService{
	boolean addTransmit(Transmit transmit);
	boolean deleteTransmit(String articleId,String userId);
	boolean isTransmit(String articleId,String userId);
	List<Transmit> getListArticleByUid(String userId);
}
