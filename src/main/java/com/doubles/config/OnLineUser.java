package com.doubles.config;

import com.doubles.entity.Users;
import com.doubles.model.SingletonList;
import com.doubles.util.Logger;
import com.doubles.util.SecretUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @时间: 2018/4/25
 * @描述：
 */
@WebListener
public class OnLineUser implements HttpSessionListener {
    private final Logger LOGGER = Logger.getLogger(OnLineUser.class);

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("【HttpSessionListener监听器】:用户登录，创建session");
        HttpSession session = httpSessionEvent.getSession();
        ServletContext application = session.getServletContext();
        Users user = (Users)application.getAttribute("user");
        SingletonList.getInstance().addUser(user.getUserId());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        LOGGER.info("【HttpSessionListener监听器】:关闭浏览器，销毁session");
        HttpSession session = httpSessionEvent.getSession();
        ServletContext application = session.getServletContext();
        Users user = (Users) application.getAttribute("user");
        // 销毁的session均从HashSet集中移除
        SingletonList.getInstance().removedUser(user.getUserId());
    }


}
