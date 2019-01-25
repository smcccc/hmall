package com.honpe.mapper;

import com.honpe.po.InquiryMateriel;
import com.honpe.po.InquiryMaterielExample;
import com.honpe.pojo.ext.InquiryMaterielExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryMaterielMapper {
	int countByExample(InquiryMaterielExample example);

	int deleteByExample(InquiryMaterielExample example);

	int deleteByPrimaryKey(String id);

	int insert(InquiryMateriel record);

	int insertSelective(InquiryMateriel record);

	List<InquiryMateriel> selectByExample(InquiryMaterielExample example);

	InquiryMateriel selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") InquiryMateriel record,
			@Param("example") InquiryMaterielExample example);

	int updateByExample(@Param("record") InquiryMateriel record, @Param("example") InquiryMaterielExample example);

	int updateByPrimaryKeySelective(InquiryMateriel record);

	int updateByPrimaryKey(InquiryMateriel record);

	List<InquiryMaterielExt> selectByInquiryId(@Param("inquiryId") String inquiryId);

	void updateStatusByPrimaryKeyAndCustomerId(@Param("status") Byte status, @Param("materielId") String materielId,
			@Param("customerId") String customerId);
}