package com.honpe.mapper;

import com.honpe.po.YxAreaTable;
import com.honpe.po.YxAreaTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YxAreaTableMapper {
    int countByExample(YxAreaTableExample example);

    int deleteByExample(YxAreaTableExample example);

    int deleteByPrimaryKey(Integer yatId);

    int insert(YxAreaTable record);

    int insertSelective(YxAreaTable record);

    List<YxAreaTable> selectByExample(YxAreaTableExample example);

    YxAreaTable selectByPrimaryKey(Integer yatId);

    int updateByExampleSelective(@Param("record") YxAreaTable record, @Param("example") YxAreaTableExample example);

    int updateByExample(@Param("record") YxAreaTable record, @Param("example") YxAreaTableExample example);

    int updateByPrimaryKeySelective(YxAreaTable record);

    int updateByPrimaryKey(YxAreaTable record);
}