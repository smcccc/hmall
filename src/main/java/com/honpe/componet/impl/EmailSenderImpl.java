package com.honpe.componet.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import com.honpe.componet.EmailSender;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@Component
public class EmailSenderImpl implements EmailSender {

	@Autowired
	private JavaMailSenderImpl javaMailSender;
	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer;
	private final String DEFAULT_TEMPLATE = "mail.ftl";

	@Override
	public void sendEmail(String template, String fromUser, String toUser, String subject, String content) {
		if (StringUtils.isBlank(fromUser)) {
			fromUser = javaMailSender.getUsername();
		}
		Map<String, Object> data = new HashMap<>();
		data.put("content", content);
		try {
			if (StringUtils.isBlank(template)) {
				template = DEFAULT_TEMPLATE;
			}
			send(fromUser, toUser, subject, data, template);
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void send(String fromUser, String toUser, String subject, Map<String, Object> map, String templatePath)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException {
		Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath, "utf-8");
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
		this.threadPoolTaskExecutor.execute(new SendMailThread(fromUser, toUser, subject, text));
	}

	private class SendMailThread implements Runnable {
		private String fromUser;
		private String to;
		private String subject;
		private String content;

		private SendMailThread(String fromUser, String to, String subject, String content) {
			super();
			this.fromUser = fromUser;
			this.to = to;
			this.subject = subject;
			this.content = content;
		}

		@Override
		public void run() {
			send(fromUser, to, subject, content);
		}

		private static final String NAME = "honpe";

		public void send(String fromUser, String to, String subject, String text) {
			try {
				MimeMessage message = javaMailSender.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
				InternetAddress from = new InternetAddress();
				from.setAddress(fromUser);
				from.setPersonal(NAME, "UTF-8");
				helper.setFrom(from);
				helper.setTo(to);
				helper.setSubject(subject);
				helper.setText(text, true);
				javaMailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
