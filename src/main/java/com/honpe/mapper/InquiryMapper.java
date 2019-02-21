package com.honpe.mapper;

import com.honpe.po.Inquiry;
import com.honpe.po.InquiryExample;
import com.honpe.pojo.ext.InquiryExt;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryMapper {
	int countByExample(InquiryExample example);

	int deleteByExample(InquiryExample example);

	int deleteByPrimaryKey(String id);

	int insert(Inquiry record);

	int insertSelective(Inquiry record);

	List<Inquiry> selectByExample(InquiryExample example);

	Inquiry selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Inquiry record, @Param("example") InquiryExample example);

	int updateByExample(@Param("record") Inquiry record, @Param("example") InquiryExample example);

	int updateByPrimaryKeySelective(Inquiry record);

	int updateByPrimaryKey(Inquiry record);

	List<InquiryExt> selectByCondition(@Param("salesmanId") Integer salesmanId, @Param("status") Byte status,
			@Param("search") String search, @Param("isOffered") Boolean isOffered);

	long selectCountByCustomerIdAndStatus(@Param("customerId") String customerId, @Param("status") Byte status);

	List<InquiryExt> selectInquiryByCondition(@Param("customerId") String customerId, @Param("status") Byte status,
			@Param("days") Integer days, @Param("search") String search);

	long selectCountByDate(@Param("beginDate") Date beginDate, @Param("endDate") Date endDate,
			@Param("dayDate") Date dayDate);
}