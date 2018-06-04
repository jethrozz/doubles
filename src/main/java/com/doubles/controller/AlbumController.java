package com.doubles.controller;


import com.doubles.dao.ImageMapper;
import com.doubles.entity.*;
import com.doubles.model.CommonResult;
import com.doubles.model.MyAlbum;
import com.doubles.model.PageInfo;
import com.doubles.model.ResultAlbum;
import com.doubles.service.AlbumService;
import com.doubles.service.ArticleService;
import com.doubles.service.RelationshipService;
import com.doubles.service.UsersService;
import com.doubles.util.Utils;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.awt.font.ImageGraphicAttribute;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * 相册 前端控制器
 * </p>
 *
 * @author shuang
 * @since 2018-04-24
 */
@Controller
@RequestMapping("/users")
public class AlbumController {

	@Autowired
	private UsersService userService;
	@Autowired
	private AlbumService albumService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private RelationshipService relationshipService;
	@Autowired
	private ImageMapper imageMapper;

	@RequestMapping("/createAlbum")
	@ResponseBody
	public String createAlbum(HttpServletRequest request,Album album){
		CommonResult<String> result = new CommonResult<>(0,"create album success");
		Users user = (Users)request.getSession().getAttribute("user");
		album.setUserId(user.getUserId());

		if(!albumService.addAlbum(album)){
			result.setStauts(1);
			result.setMsg("create album failed");
		}

		return Utils.toJson(result);

	}

	@RequestMapping("/getAlbumList")
	@ResponseBody
	public String getAlbumList(HttpServletRequest request, String userId, @RequestParam(defaultValue = "1") int pageNo,@RequestParam(defaultValue = "20") int pageSize){
		CommonResult<PageInfo<Album>> result = new CommonResult<>(0,"success");
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}
		Page<Album> pageAlbum = albumService.getAlbumPageByUser(userId,pageNo,pageSize);
		PageInfo<Album> albumPageInfo = new PageInfo<>(pageAlbum);

		result.setData(albumPageInfo);
		return Utils.toJson(result);
	}

	@RequestMapping("/getAlbumImgList")
	public ModelAndView getAlbumImgList(HttpServletRequest request, String userId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "20") int pageSize){
		Users user = (Users)request.getSession().getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM月/dd");
		ModelAndView modelAndView = new ModelAndView("/file");

		//根据时间分组，先获取到所有的时间
		List<Date> dateList = articleService.getTimeGroup(userId);
		//获取到该用户的所有相册以及相册下的图片

		//根据日期构建图集，首先先把所有图片按日期分组
		MyAlbum myAlbum = null;
		List<MyAlbum> albumList = null;
		List<ResultAlbum>  resultAlbumList = new ArrayList<>();
		for (Date d: dateList ) {
			//先按日期获取动态
			List<Article> articleList = articleService.getArticleByTime(sdf.format(d),userId);
			if(articleList == null || articleList.size() == 0){
				continue;
			}
			albumList = new ArrayList<>();
			//再遍历该日期下的动态。封装需要的数据
			for (Article article: articleList ) {
				if(article.getImgList() == null || article.getImgList().size() == 0){
					continue;
				}
				myAlbum = new MyAlbum();
				//利用正则表达式找出动态的所有图片
				String regex = "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(article.getContent());

				if(matcher.find()){
					myAlbum.setImgSrc(matcher.group());
				}else{
					continue;
				}
				myAlbum.setArticleId(article.getArticleId());
				albumList.add(myAlbum);
			}
			ResultAlbum resultAlbum = new ResultAlbum();
			resultAlbum.setAlbumTime(sdf1.format(d));

			resultAlbum.setAlbumList(albumList);
			resultAlbumList.add(resultAlbum);
		}
		Collections.reverse(resultAlbumList);
		Relationship relationship = relationshipService.isFriend(user.getUserId(),userId);
		Users object = userService.getOne(userId);


		modelAndView.addObject("albumList",resultAlbumList);
		modelAndView.addObject("object",object);

		if(user.getUserId().equals(userId) && relationship == null){
			modelAndView.addObject("relationship",3);
		}else if(relationship == null){
			modelAndView.addObject("relationship",1);
		}else{
			modelAndView.addObject("relationship",(int)relationship.getIsFriend());
		}
		return modelAndView;
	}

	@RequestMapping("/getAlbumImgJson")
	@ResponseBody
	public String getAlbumImgJson(String userId,String date){
		CommonResult<List<ResultAlbum>> result = new CommonResult<>();
		if(StringUtils.isEmpty(userId)){
			result.setStauts(1);
			result.setMsg("userId is empty");
			return Utils.toJson(result);
		}
		if(StringUtils.isEmpty(date)){
			result.setStauts(1);
			result.setMsg("date is empty");
			return Utils.toJson(result);
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM月/dd");

		List<ResultAlbum> list = new ArrayList<>();

		//根据时间分组，先获取到所有的时间
		//List<Date> dateList = articleService.getTimeGroup();

		MyAlbum myAlbum = null;
		List<MyAlbum> albumList = null;
		List<ResultAlbum>  resultAlbumList = new ArrayList<>();
		//for (Date d: dateList ) {
			//先按日期获取动态
			List<Article> articleList = articleService.getArticleByTime(date,userId);
			if(articleList != null && articleList.size() != 0){
				albumList = new ArrayList<>();
				//再遍历该日期下的动态。封装需要的数据
				ResultAlbum resultAlbum = null;
				for (Article article: articleList ) {
					if(article.getImgList() == null || article.getImgList().size() == 0){
						continue;
					}
					myAlbum = new MyAlbum();
					//利用正则表达式找出动态的所有图片
					String regex = "<img[^<>]*?\\ssrc=['\"]?(.*?)['\"].*?>";
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(article.getContent());

					if(matcher.find()){
						myAlbum.setImgSrc(matcher.group());
					}else{
						continue;
					}
					myAlbum.setArticleId(article.getArticleId());
					albumList.add(myAlbum);
					//}
					resultAlbum = new ResultAlbum();
					try {
						resultAlbum.setAlbumTime(sdf1.format(sdf.parse(date)));
					} catch (ParseException e) {
						result.setStauts(1);
						result.setMsg("date format is error");
						return Utils.toJson(result);
					}

					resultAlbum.setAlbumList(albumList);

				}
				resultAlbumList.add(resultAlbum);
			}


		result.setData(resultAlbumList);
		return Utils.toJson(result);
	}



}

