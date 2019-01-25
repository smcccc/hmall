package com.honpe.file.util;

import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Calendar;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class SaveFile {

	/**
	 * @param savePath // 保存路径
	 * @param fileFullName //全名
	 * @param file //文件对象
	 * @return
	 * @throws Exception
	 */
	public static boolean saveFile(@NotNull final String savePath, @NotNull final String fileFullName,
			@NotNull final MultipartFile file) throws Exception {
		File uploadFile = new File(savePath, fileFullName);
		File fileDirectory = new File(savePath);
		synchronized (fileDirectory) {
			if (!fileDirectory.exists()) {
				if (!fileDirectory.mkdir()) {
					throw new Exception("保存文件的父文件夹创建失败！路径为：" + savePath);
				}
			}
			if (!fileDirectory.exists()) {
				if (!fileDirectory.mkdir()) {
					throw new Exception("文件夹创建失败！路径为：" + savePath);
				}
			}
		}
		file.transferTo(uploadFile);
		return uploadFile.exists();
	}
}
