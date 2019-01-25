package com.honpe.mapper;

import com.honpe.po.Account;
import com.honpe.po.AccountExample;
import com.honpe.pojo.ext.AccountExt;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
	int countByExample(AccountExample example);

	int deleteByExample(AccountExample example);

	int deleteByPrimaryKey(String id);

	int insert(Account record);

	int insertSelective(Account record);

	List<Account> selectByExample(AccountExample example);

	Account selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

	int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

	int updateByPrimaryKeySelective(Account record);

	int updateByPrimaryKey(Account record);

	List<AccountExt> selectByCondition(@Param("orderNum") Integer orderNum, @Param("userName") String userName,
			@Param("company") String company, @Param("salesman") String salesman);
}