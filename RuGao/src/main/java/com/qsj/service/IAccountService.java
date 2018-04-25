package com.qsj.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IAccountService {
	public void testUpdate(String aid1,
			String aid2,Integer money);
}
