package com.honpe.mapper;

import com.honpe.po.TbOrder;
import com.honpe.po.TbOrderExample;
import com.honpe.pojo.ext.OrderExt;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface TbOrderMapper {
	int countByExample(TbOrderExample example);

	int deleteByExample(TbOrderExample example);

	int deleteByPrimaryKey(String orderId);

	int insert(TbOrder record);

	int insertSelective(TbOrder record);

	List<TbOrder> selectByExample(TbOrderExample example);

	TbOrder selectByPrimaryKey(String orderId);

	int updateByExampleSelective(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

	int updateByExample(@Param("record") TbOrder record, @Param("example") TbOrderExample example);

	int updateByPrimaryKeySelective(TbOrder record);

	int updateByPrimaryKey(TbOrder record);

	List<OrderExt> selectByConditions(@Param("search") String search, @Param("buyerId") String buyerId,
			@Param("beginTime") Date beginTime, @Param("endTime") Date endTime, @Param("status") Byte status);
	
	long selectCountByStatus(@Param("buyerId") String buyerId, @Param("status") Byte status);
}