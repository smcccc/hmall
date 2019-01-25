package com.honpe.file.util;

import org.jetbrains.annotations.NotNull;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamUtil {
	
	public static void saveStreamToFile(@NotNull final InputStream inputStream, @NotNull final String filePath)
			throws Exception {
		OutputStream outputStream = new FileOutputStream(filePath);
		byte[] buffer = new byte[1024];
		int len = 0;
		try {
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
				outputStream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			outputStream.close();
			inputStream.close();
		}
	}
}
