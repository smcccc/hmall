package com.honpe.test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.Calendar;
import org.junit.Test;
import com.honpe.utils.EncryptUtils;

public class JunitTest {
	@Test
	public void test() throws IOException {
		fn4();
	}

	private void fn4() {
		Encoder encoder = Base64.getEncoder();
		String enstr = encoder.encodeToString("asdasdadad.".getBytes());
		System.out.println(enstr);
		Decoder decoder = Base64.getDecoder();
		String deStr = new String(decoder.decode(enstr.getBytes()));
		System.out.println(deStr);
	}

	private void fn2() throws ParseException {
		Calendar instance = Calendar.getInstance();
		// instance.set(Calendar.DAY_OF_WEEK_IN_MONTH, value);
		instance.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(instance.getTime());
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

