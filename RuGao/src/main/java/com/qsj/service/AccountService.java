package com.qsj.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qsj.dao.AccountMapper;
import com.qsj.service.ex.ServiceException;

@Service
public class AccountService 
	implements IAccountService{
	@Resource
	private AccountMapper accountMapper;
	public void testUpdate(String aid1, String aid2, Integer money) {
		Integer n1 = 
				accountMapper.update1(aid1,
				accountMapper.select1(aid1)-money);
		if(n1==0)
			throw new ServiceException("用户不存在");
		Integer n2 =
				accountMapper.update2(aid2, 
				accountMapper.select2(aid2)+money);
		if(n2==0)
			throw new ServiceException("用户不存在");
	}

}




