package com.doubles.serviceImpl;

import com.doubles.dao.AdminMapper;
import com.doubles.dao.AlbumMapper;
import com.doubles.entity.Album;
import com.doubles.entity.AlbumExample;
import com.doubles.service.AlbumService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 相册 服务实现类
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Service
public class AlbumServiceImpl implements AlbumService {
	@Autowired
	private AlbumMapper albumMapper;
	@Override
	public boolean addAlbum(Album album) {
		if(albumMapper.insertSelective(album) >= 1){
			return true;
		}else return false;
	}

	@Override
	public Album getAlbumByuserIdAndName(String userId) {
		AlbumExample example = new AlbumExample();
		example.or().andUserIdEqualTo(userId).andAlbumNameEqualTo("动态相册").andAlbumDescribeEqualTo("动态相册");
		List<Album> list = albumMapper.selectByExample(example);

		if(list.size() == 0 || null == list){
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<Album> getAlbumListByUser(String userId) {
		AlbumExample example = new AlbumExample();
		example.or().andUserIdEqualTo(userId);
		example.setOrderByClause("create_time desc");
		return albumMapper.selectByExample(example);
	}

	@Override
	public Page<Album> getAlbumPageByUser(String userId, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return albumMapper.getAlbumPageByUser(userId);
	}

	@Override
	public Album getAlbumById(String id) {
		return albumMapper.selectByPrimaryKey(id);
	}
}
