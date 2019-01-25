package com.honpe.mapper;

import com.honpe.po.OrderOperate;
import com.honpe.po.OrderOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderOperateMapper {
    int countByExample(OrderOperateExample example);

    int deleteByExample(OrderOperateExample example);

    int deleteByPrimaryKey(Long operateId);

    int insert(OrderOperate record);

    int insertSelective(OrderOperate record);

    List<OrderOperate> selectByExample(OrderOperateExample example);

    OrderOperate selectByPrimaryKey(Long operateId);

    int updateByExampleSelective(@Param("record") OrderOperate record, @Param("example") OrderOperateExample example);

    int updateByExample(@Param("record") OrderOperate record, @Param("example") OrderOperateExample example);

    int updateByPrimaryKeySelective(OrderOperate record);

    int updateByPrimaryKey(OrderOperate record);
}