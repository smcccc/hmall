package com.honpe.file.service;

import com.honpe.po.FileInfo;

public interface FileService {

	void saveTempFile(FileInfo fileInfo);

	Boolean isMd5Exist(String md5, String filename);
}
