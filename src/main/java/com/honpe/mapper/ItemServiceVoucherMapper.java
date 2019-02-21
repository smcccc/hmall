package com.honpe.mapper;

import com.honpe.po.ItemServiceVoucher;
import com.honpe.po.ItemServiceVoucherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemServiceVoucherMapper {
    int countByExample(ItemServiceVoucherExample example);

    int deleteByExample(ItemServiceVoucherExample example);

    int deleteByPrimaryKey(String voucherId);

    int insert(ItemServiceVoucher record);

    int insertSelective(ItemServiceVoucher record);

    List<ItemServiceVoucher> selectByExample(ItemServiceVoucherExample example);

    ItemServiceVoucher selectByPrimaryKey(String voucherId);

    int updateByExampleSelective(@Param("record") ItemServiceVoucher record, @Param("example") ItemServiceVoucherExample example);

    int updateByExample(@Param("record") ItemServiceVoucher record, @Param("example") ItemServiceVoucherExample example);

    int updateByPrimaryKeySelective(ItemServiceVoucher record);

    int updateByPrimaryKey(ItemServiceVoucher record);
}