package com.doubles.serviceImpl;

import com.doubles.dao.ImageMapper;
import com.doubles.entity.Image;
import com.doubles.entity.ImageExample;
import com.doubles.service.ImageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

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

	@Override
	public boolean addImage(Image image) {
		if(imageDao.insertSelective(image) >= 1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Image> getImageListByAlbum(String id) {
		ImageExample example = new ImageExample();
		example.or().andAlbumIdEqualTo(id);
		example.setOrderByClause("create_time desc");
		return imageDao.selectByExample(example);
	}

	@Override
	public Page<Image> getImagePageByAlbum(String id,int pageNo,int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return imageDao.getImagePageByAlbum(id);
	}
}
