package com.honpe.mapper;

import com.honpe.po.OrderBargain;
import com.honpe.po.OrderBargainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderBargainMapper {
    int countByExample(OrderBargainExample example);

    int deleteByExample(OrderBargainExample example);

    int deleteByPrimaryKey(String bargainId);

    int insert(OrderBargain record);

    int insertSelective(OrderBargain record);

    List<OrderBargain> selectByExample(OrderBargainExample example);

    OrderBargain selectByPrimaryKey(String bargainId);

    int updateByExampleSelective(@Param("record") OrderBargain record, @Param("example") OrderBargainExample example);

    int updateByExample(@Param("record") OrderBargain record, @Param("example") OrderBargainExample example);

    int updateByPrimaryKeySelective(OrderBargain record);

    int updateByPrimaryKey(OrderBargain record);
}