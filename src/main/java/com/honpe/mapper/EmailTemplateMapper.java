package com.honpe.mapper;

import com.honpe.po.EmailTemplate;
import com.honpe.po.EmailTemplateExample;
import com.honpe.po.EmailTemplateWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailTemplateMapper {
    int countByExample(EmailTemplateExample example);

    int deleteByExample(EmailTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmailTemplateWithBLOBs record);

    int insertSelective(EmailTemplateWithBLOBs record);

    List<EmailTemplateWithBLOBs> selectByExampleWithBLOBs(EmailTemplateExample example);

    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    EmailTemplateWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmailTemplateWithBLOBs record, @Param("example") EmailTemplateExample example);

    int updateByExampleWithBLOBs(@Param("record") EmailTemplateWithBLOBs record, @Param("example") EmailTemplateExample example);

    int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    int updateByPrimaryKeySelective(EmailTemplateWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(EmailTemplateWithBLOBs record);

    int updateByPrimaryKey(EmailTemplate record);
}