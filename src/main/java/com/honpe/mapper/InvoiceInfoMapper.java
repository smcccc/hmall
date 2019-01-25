package com.honpe.mapper;

import com.honpe.po.InvoiceInfo;
import com.honpe.po.InvoiceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InvoiceInfoMapper {
    int countByExample(InvoiceInfoExample example);

    int deleteByExample(InvoiceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InvoiceInfo record);

    int insertSelective(InvoiceInfo record);

    List<InvoiceInfo> selectByExample(InvoiceInfoExample example);

    InvoiceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InvoiceInfo record, @Param("example") InvoiceInfoExample example);

    int updateByExample(@Param("record") InvoiceInfo record, @Param("example") InvoiceInfoExample example);

    int updateByPrimaryKeySelective(InvoiceInfo record);

    int updateByPrimaryKey(InvoiceInfo record);
	int selectCountByAccId(@Param("accId") String accId);
}