package com.honpe.mapper;

import com.honpe.po.OrderPayment;
import com.honpe.po.OrderPaymentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPaymentMapper {
    int countByExample(OrderPaymentExample example);

    int deleteByExample(OrderPaymentExample example);

    int deleteByPrimaryKey(String orderId);

    int insert(OrderPayment record);

    int insertSelective(OrderPayment record);

    List<OrderPayment> selectByExample(OrderPaymentExample example);

    OrderPayment selectByPrimaryKey(String orderId);

    int updateByExampleSelective(@Param("record") OrderPayment record, @Param("example") OrderPaymentExample example);

    int updateByExample(@Param("record") OrderPayment record, @Param("example") OrderPaymentExample example);

    int updateByPrimaryKeySelective(OrderPayment record);

    int updateByPrimaryKey(OrderPayment record);
}