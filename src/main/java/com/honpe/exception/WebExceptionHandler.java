/*
 * Copyright 2015-2102 RonCoo(http://www.roncoo.com) Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.honpe.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingErrorProcessor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alibaba.druid.support.json.JSONUtils;
import com.honpe.pojo.vo.Result;
import com.honpe.utils.JsonUtils;

@ControllerAdvice
public class WebExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(WebExceptionHandler.class);

	/**
	 * 权限异常
	 */
	@ExceptionHandler({ UnauthorizedException.class })
	@ResponseStatus(HttpStatus.OK)
	public String processUnauthorizedException(HttpServletRequest request, HttpServletResponse response,
			UnauthorizedException e) {
		logger.error("UnauthorizedException", e);
		if (isAjaxRequest(request)) {
			sendJson(response, new Result(405, "您的权限不足", null));
			return null;
		}
		return "admin/unauthorized";
	}

	/**
	 * 总异常
	 */
	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.OK)
	public String processException(Exception e, HttpServletRequest request, HttpServletResponse response) {
		logger.error("Exception", e);
		if (isAjaxRequest(request)) {
			sendJson(response, new Result(500, "内部服务器异常请稍后重试", null));
			return null;
		} else {
			return "redirect:/admin";
		}
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
}
