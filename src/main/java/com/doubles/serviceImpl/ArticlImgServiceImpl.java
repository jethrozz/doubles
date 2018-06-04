package com.doubles.serviceImpl;

import com.doubles.dao.ArticlImgMapper;
import com.doubles.dao.ImageMapper;
import com.doubles.entity.ArticlImg;
import com.doubles.entity.ArticlImgExample;
import com.doubles.entity.Image;
import com.doubles.service.ArticlImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 动态图片表

动态相册，如果是动态中的图片，则要存入该表中，表示这张图片是哪个动态的 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class ArticlImgServiceImpl implements ArticlImgService {

	@Autowired
	private ArticlImgMapper articlImgDao;
	@Autowired
	private ImageMapper imgDao;
	@Override
	public List<Image> findImgByArticleId(String article_id) {
		ArticlImgExample example = new ArticlImgExample();
		example.or().andArticleIdEqualTo(article_id);
		List<ArticlImg> articlImgList = articlImgDao.selectByExample(example);
		List<Image> imageList = new ArrayList<>();
		for (ArticlImg articlImg : articlImgList){
			imageList.add(imgDao.selectByPrimaryKey(articlImg.getImgId()));
		}
		return imageList;
	}

	@Override
	@Transactional
	public boolean addImage(ArticlImg articlImg) {
		if(articlImgDao.insertSelective(articlImg) >= 1){
			return true;
		}else{
			return false;
		}
	}
}
