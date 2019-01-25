package com.honpe.mapper;

import com.honpe.po.TransportTemplate;
import com.honpe.po.TransportTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TransportTemplateMapper {
    int countByExample(TransportTemplateExample example);

    int deleteByExample(TransportTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransportTemplate record);

    int insertSelective(TransportTemplate record);

    List<TransportTemplate> selectByExample(TransportTemplateExample example);

    TransportTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransportTemplate record, @Param("example") TransportTemplateExample example);

    int updateByExample(@Param("record") TransportTemplate record, @Param("example") TransportTemplateExample example);

    int updateByPrimaryKeySelective(TransportTemplate record);

    int updateByPrimaryKey(TransportTemplate record);
}