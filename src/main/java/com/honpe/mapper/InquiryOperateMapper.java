package com.honpe.mapper;

import com.honpe.po.InquiryOperate;
import com.honpe.po.InquiryOperateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InquiryOperateMapper {
    int countByExample(InquiryOperateExample example);

    int deleteByExample(InquiryOperateExample example);

    int deleteByPrimaryKey(Long operateId);

    int insert(InquiryOperate record);

    int insertSelective(InquiryOperate record);

    List<InquiryOperate> selectByExample(InquiryOperateExample example);

    InquiryOperate selectByPrimaryKey(Long operateId);

    int updateByExampleSelective(@Param("record") InquiryOperate record, @Param("example") InquiryOperateExample example);

    int updateByExample(@Param("record") InquiryOperate record, @Param("example") InquiryOperateExample example);

    int updateByPrimaryKeySelective(InquiryOperate record);

    int updateByPrimaryKey(InquiryOperate record);
}