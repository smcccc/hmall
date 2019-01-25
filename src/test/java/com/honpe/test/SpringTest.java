package com.honpe.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.honpe.content.service.CategoryService;
import com.honpe.content.service.ContentService;
import com.honpe.inquiry.enums.InquiryEnum;
import com.honpe.inquiry.service.InquiryMaterielService;
import com.honpe.inquiry.service.InquiryService;
import com.honpe.log.service.OperateLogService;
import com.honpe.mapper.InquiryMapper;
import com.honpe.mapper.TbOrderMapper;
import com.honpe.menu.service.MenuService;
import com.honpe.perm.service.PermService;
import com.honpe.po.InquiryMateriel;
import com.honpe.po.SysUser;
import com.honpe.pojo.ext.InquiryExt;
import com.honpe.pojo.ext.InquiryMaterielExt;
import com.honpe.role.service.RoleService;
import com.honpe.user.service.SysUserService;
import com.honpe.utils.IpHelper;
import com.honpe.utils.PasswordHelper;
import com.honpe.utils.XMLHelper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/ctx-bean.xml", "classpath:spring/ctx-jdbc.xml",
		"classpath:spring/ctx-tx.xml", "classpath:spring/ctx-mail.xml" })
public class SpringTest {
	@Autowired
	private InquiryMaterielService inquiryMaterielService;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private InquiryService inquiryService;
	@Autowired
	private TbOrderMapper orderMapper;

	@Test
	public void test() {
		long count = orderMapper.selectCountByStatus("1bb60cf5-0c96-11e9-8d62-fcaa140e20bd", (byte)7);
		System.out.println(count);
	}

	private void sendMail() throws MessagingException, UnsupportedEncodingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom(new InternetAddress("heshengbinvip@163.com", "honpe"));
		helper.setSubject("客户报价");
		helper.setText("测试", true);
		helper.setTo("313572052@qq.com");
		javaMailSender.send(message);
	}

	private void fn3() {
		SysUser sysUser = new SysUser();
		sysUser.setLoginPass("123456");
		PasswordHelper.encryptPassword(sysUser);
		System.out.println(sysUser.getLoginPass());
		System.out.println(sysUser.getSalt());
	}

	private void fn2() {
		SysUser sysUser = new SysUser();
		sysUser.setLoginPass("adminn");
		PasswordHelper.encryptPassword(sysUser);
		System.out.println(sysUser.getLoginPass());
		System.out.println(sysUser.getSalt());
	}

}
