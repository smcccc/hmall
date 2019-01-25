package com.honpe.mapper;

import com.honpe.po.FileInfo;
import com.honpe.po.FileInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FileInfoMapper {
	int countByExample(FileInfoExample example);

	int deleteByExample(FileInfoExample example);

	int deleteByPrimaryKey(String fileId);

	int insert(FileInfo record);

	int insertSelective(FileInfo record);

	List<FileInfo> selectByExample(FileInfoExample example);

	FileInfo selectByPrimaryKey(String fileId);

	int updateByExampleSelective(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

	int updateByExample(@Param("record") FileInfo record, @Param("example") FileInfoExample example);

	int updateByPrimaryKeySelective(FileInfo record);

	int updateByPrimaryKey(FileInfo record);

	FileInfo selectByMaterielId(@Param("materielId") String materielId);
}