package com.doubles.serviceImpl;

import com.doubles.dao.ImageMapper;
import com.doubles.entity.Image;
import com.doubles.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;

/**
 * <p>
 * 图片表 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ImageServiceImpl  implements ImageService {

	@Autowired
	ImageMapper imageDao;
	@Override
	public Image getOneImg(String imgId) {
		return imageDao.selectByPrimaryKey(imgId);
	}

	@Override
	public boolean updateImg(Image image) {
		if(imageDao.updateByPrimaryKeySelective(image) >= 1){
			return true;
		}
		return false;
	}
}
