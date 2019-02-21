package com.honpe.mapper;

import com.honpe.po.ItemServiceApply;
import com.honpe.po.ItemServiceApplyExample;
import com.honpe.pojo.ext.ItemServiceApplyExt;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemServiceApplyMapper {
    int countByExample(ItemServiceApplyExample example);

    int deleteByExample(ItemServiceApplyExample example);

    int deleteByPrimaryKey(String orderItemId);

    int insert(ItemServiceApply record);

    int insertSelective(ItemServiceApply record);

    List<ItemServiceApply> selectByExample(ItemServiceApplyExample example);

    ItemServiceApply selectByPrimaryKey(String orderItemId);

    int updateByExampleSelective(@Param("record") ItemServiceApply record, @Param("example") ItemServiceApplyExample example);

    int updateByExample(@Param("record") ItemServiceApply record, @Param("example") ItemServiceApplyExample example);

    int updateByPrimaryKeySelective(ItemServiceApply record);

    int updateByPrimaryKey(ItemServiceApply record);

	List<ItemServiceApplyExt> selectByConditions(@Param("search") String search,
			@Param("salesmanId") Integer salesmanId, @Param("beginTime") Date beginTime, @Param("endTime") Date endTime,
			@Param("status") Byte status);
}