package com.honpe.test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import com.honpe.utils.EncryptUtils;
import com.honpe.utils.IDUtils;
import com.mysql.jdbc.Field;

import freemarker.template.SimpleDate;

public class JunitTest {
	@Test
	public void test() throws ParseException {
		
	}

	private void fn2() throws ParseException {
		Calendar instance = Calendar.getInstance();
		// instance.set(Calendar.DAY_OF_WEEK_IN_MONTH, value);
		instance.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(instance.getTime());
		System.out.println(date);
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.SATURDAY);
		// System.out.println(Calendar.SATURDAY);
		// System.out.println(Calendar.SUNDAY);
		// System.out.println(Calendar.MONDAY);
		// System.out.println(i);
	}

	private void fn3() {
		String string = "313572052@qq.com";
		int indexOf = string.indexOf('@');
		StringBuffer stringBuffer = new StringBuffer(string);
		for (int i = (string.length() - indexOf - 1); i < indexOf; i++) {
			stringBuffer.replace(i, i + 1, "*");
		}
		System.out.println(stringBuffer.toString());
	}

	private void fn1() {
		try {
			String encrypt = EncryptUtils.SINGLETON.encryptByAes("313572052@qq.com");
			System.out.println(encrypt);
			System.out.println(EncryptUtils.SINGLETON.decryptByAes(encrypt));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
