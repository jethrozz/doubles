package com.doubles.util;

import com.doubles.entity.Users;
import com.doubles.model.SingletonOnlineUserList;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 */
public class UserInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		/**
		 * 对来自后台的请求统一进行日志处理
		 */
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute("user");
		if(user == null ){
			response.sendRedirect("../users/login");
			return false;
		}else if(user != null){
			if (!SingletonOnlineUserList.getInstance().getUserList().contains(user.getUserId())){
				SingletonOnlineUserList.getInstance().getUserList().add(user.getUserId());
			}
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

	}
}
