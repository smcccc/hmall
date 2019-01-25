package com.honpe.mapper;

import com.honpe.po.DictType;
import com.honpe.po.DictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictTypeMapper {
    int countByExample(DictTypeExample example);

    int deleteByExample(DictTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictType record);

    int insertSelective(DictType record);

    List<DictType> selectByExample(DictTypeExample example);

    DictType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictType record, @Param("example") DictTypeExample example);

    int updateByExample(@Param("record") DictType record, @Param("example") DictTypeExample example);

    int updateByPrimaryKeySelective(DictType record);

    int updateByPrimaryKey(DictType record);
}