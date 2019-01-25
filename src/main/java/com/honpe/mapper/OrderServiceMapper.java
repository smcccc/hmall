package com.honpe.mapper;

import com.honpe.po.OrderService;
import com.honpe.po.OrderServiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderServiceMapper {
    int countByExample(OrderServiceExample example);

    int deleteByExample(OrderServiceExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderService record);

    int insertSelective(OrderService record);

    List<OrderService> selectByExample(OrderServiceExample example);

    OrderService selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderService record, @Param("example") OrderServiceExample example);

    int updateByExample(@Param("record") OrderService record, @Param("example") OrderServiceExample example);

    int updateByPrimaryKeySelective(OrderService record);

    int updateByPrimaryKey(OrderService record);
}