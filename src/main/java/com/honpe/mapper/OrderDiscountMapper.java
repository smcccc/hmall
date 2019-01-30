package com.honpe.mapper;

import com.honpe.po.OrderDiscount;
import com.honpe.po.OrderDiscountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDiscountMapper {
    int countByExample(OrderDiscountExample example);

    int deleteByExample(OrderDiscountExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderDiscount record);

    int insertSelective(OrderDiscount record);

    List<OrderDiscount> selectByExample(OrderDiscountExample example);

    OrderDiscount selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderDiscount record, @Param("example") OrderDiscountExample example);

    int updateByExample(@Param("record") OrderDiscount record, @Param("example") OrderDiscountExample example);

    int updateByPrimaryKeySelective(OrderDiscount record);

    int updateByPrimaryKey(OrderDiscount record);
}