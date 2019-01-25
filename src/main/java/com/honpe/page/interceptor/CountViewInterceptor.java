package com.honpe.page.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.ComponentView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.honpe.count.service.CountService;
import com.honpe.page.annotation.CountView;
import com.honpe.po.ViewCount;

public class CountViewInterceptor implements HandlerInterceptor {

	@Autowired
	private CountService countService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hMethod = (HandlerMethod) handler;
			CountView countView = hMethod.getMethodAnnotation(CountView.class);
			if (countView != null) {
				int id = countView.id();
				String pageName = countView.pageName();
				ViewCount viewCount = new ViewCount();
				viewCount.setId(id);
				viewCount.setPageName(pageName);
				countService.countPageView(viewCount);
			}
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
