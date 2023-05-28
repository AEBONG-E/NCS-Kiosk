package com.kobuks.kiosk.config;

import org.apache.catalina.SessionEvent;
import org.apache.catalina.SessionListener;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Configuration
public class SessionConfig implements HttpSessionListener, ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addListener(this); // this로 현재 클래스를 전달
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        session.setMaxInactiveInterval(60); // 60초 후 세션 만료
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
