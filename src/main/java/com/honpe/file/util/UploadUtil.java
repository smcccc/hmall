package com.honpe.file.util;

import org.jetbrains.annotations.NotNull;
import com.honpe.file.model.UploadInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UploadUtil {

	private final static List<UploadInfo> uploadInfoList = new ArrayList<>();

	public static boolean isAllUploaded(@NotNull final String md5, @NotNull final Integer chunks) {
		int size = uploadInfoList.stream().filter(item -> item.getMd5().equals(md5)).distinct()
				.collect(Collectors.toList()).size();
		boolean boo = (size == chunks);
		if (boo) {
			synchronized (uploadInfoList) {
				uploadInfoList.removeIf(item -> Objects.equals(item.getMd5(), md5));
			}
		}
		return boo;
	}

	public static Boolean uploaded(@NotNull final String md5, @NotNull final String guid, @NotNull final Integer chunk,
			@NotNull final Integer chunks, @NotNull final String tempFolderPath, @NotNull final String uploadFolderPath,
			@NotNull final String fileName, @NotNull final String ext) throws Exception {
		synchronized (uploadInfoList) {
			uploadInfoList.add(new UploadInfo(md5, chunks, chunk, tempFolderPath, fileName, ext));
		}
		boolean allUploaded = isAllUploaded(md5, chunks);
		if (allUploaded) {
			mergeFile(chunks, ext, guid, tempFolderPath, uploadFolderPath);
		}
		return allUploaded;
	}

	public static void mergeFile(final int chunks, @NotNull final String ext, @NotNull final String guid,
			@NotNull final String tempFolderPath, String uploadFolderPath) throws Exception {
		SequenceInputStream s = null;
		String mergePath = tempFolderPath + '/';
		InputStream s1 = new FileInputStream(mergePath + 0 + ext);
		InputStream s2 = new FileInputStream(mergePath + 1 + ext);
		s = new SequenceInputStream(s1, s2);
		for (int i = 2; i < chunks; i++) {
			InputStream s3 = new FileInputStream(mergePath + i + ext);
			s = new SequenceInputStream(s, s3);
		}
		StreamUtil.saveStreamToFile(s, uploadFolderPath + '/' + guid + ext);
		deleteFolder(mergePath);

	}

	public static boolean deleteFolder(@NotNull final String tempFolderPath) {
		File dir = new File(tempFolderPath);
		File[] files = dir.listFiles();
		if (files != null) {
			for (File file : files) {
				try {
					file.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return dir.delete();
	}
}
