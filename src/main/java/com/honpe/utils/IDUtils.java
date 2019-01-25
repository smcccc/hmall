package com.honpe.utils;

import java.util.Random;
import org.apache.commons.io.FilenameUtils;

public class IDUtils {

	/**
	 * 询价单ID
	 */
	public static String generateId(String prefix) {
		StringBuilder sBuilder = new StringBuilder(prefix);
		long millis = System.currentTimeMillis();
		sBuilder.append(String.valueOf(millis));
		Random random = new Random();
		int end = random.nextInt(99);
		sBuilder.append(String.format("%02d", end));
		return sBuilder.toString();
	}
}
