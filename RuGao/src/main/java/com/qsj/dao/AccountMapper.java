package com.qsj.dao;

import org.apache.ibatis.annotations.Param;

public interface AccountMapper {

	Integer update1(@Param("aid") String aid,
					@Param("money") Integer money);
	Integer update2(@Param("aid") String aid,
					@Param("money") Integer money);
	Integer select1(String aid);
	Integer select2(String aid);
}





