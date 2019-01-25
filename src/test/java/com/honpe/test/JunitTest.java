package com.honpe.test;

import java.io.File;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;
import com.honpe.utils.EncryptUtils;
import com.honpe.utils.IDUtils;
import com.mysql.jdbc.Field;

public class JunitTest {
	@Test
	public void test() {
System.out.println(File.separator);
	}

	private void fn2() {
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
