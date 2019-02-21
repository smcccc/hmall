package com.honpe.file.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.honpe.mapper.FileInfoMapper;
import com.honpe.po.FileInfo;
import com.honpe.po.FileInfoExample;

@Service
@Transactional
public class FileServiceImpl implements FileService {

	@Autowired
	private FileInfoMapper fileInfoMapper;

	@Override
	public void saveTempFile(FileInfo fileInfo) {
		// TODO Auto-generated method stub
		fileInfoMapper.insertSelective(fileInfo);
	}

	@Override
	public String isMd5Exist(String md5, String filename) {
		FileInfoExample fileInfoExample = new FileInfoExample();
		fileInfoExample.createCriteria().andMd5EqualTo(md5).andFileNameEqualTo(filename);
		List<FileInfo> files = fileInfoMapper.selectByExample(fileInfoExample);
		if (files != null && files.size() > 0)
			return files.get(0).getFileId();
		return null;
	}

}
