package com.honpe.account.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.honpe.account.annotation.RequiredAuth;
import com.honpe.po.Account;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.JsonUtils;

public class AccountAuthAndPermsInterceptor implements HandlerInterceptor {

	private String unauthorizedUrl;

	private static final Logger logger = LoggerFactory.getLogger(AccountAuthAndPermsInterceptor.class);

	public AccountAuthAndPermsInterceptor(String unauthorizedUrl) {
		super();
		this.unauthorizedUrl = unauthorizedUrl;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod hMethod = (HandlerMethod) handler;
			HttpSession session = request.getSession();
			boolean isAjax = isAjaxRequest(request);
			if (session != null && !isAllowed(hMethod, session)) {
				if (isAjax) {
					sendJson(response, new Result(401, null, null));
				} else {
					response.sendRedirect(request.getContextPath() + unauthorizedUrl);
				}
				return false;
			}
		}
		return true;
	}

	private Boolean isAllowed(HandlerMethod hMethod, HttpSession session) {
		if (!hMethod.hasMethodAnnotation(RequiredAuth.class))
			return true;
		Account account = (Account) session.getAttribute("CUSTOMER");
		if (account != null)
			return true;
		return false;
	}

	private void sendJson(HttpServletResponse response, Result result) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.write(JsonUtils.objectToJson(result));
			writer.flush();
		} catch (IOException e) {
			logger.error("send json error {} :", e);
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	private boolean isAjaxRequest(ServletRequest request) {
		boolean isAjaxRequest = false;
		String requestType = ((HttpServletRequest) request).getHeader("X-Requested-With");
		if ("XMLHttpRequest".equals(requestType)) {
			isAjaxRequest = true;
		}
		return isAjaxRequest;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}
}
