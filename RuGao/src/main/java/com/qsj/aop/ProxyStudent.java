package com.qsj.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProxyStudent implements IStudent{
	@Autowired
	private Student stu;
	@Autowired
	private TestAop aop;
	
	//代理类的方法 实现功能
	public void add() {
		aop.test();
		stu.add();
		
	}

	public void update() {
		
		
	}

}
