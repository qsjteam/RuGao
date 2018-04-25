package com.qsj.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

	@Test
	public void testProxy(){
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext
				("spring-aop.xml");
	
	/*	IStudent stu = ac.getBean("proxyStudent",
				IStudent.class);
		stu.add();*/
		//获取工具类的对象
		ProxyStudent2 ps = ac.getBean("proxyStudent2",
				ProxyStudent2.class);
		//获取动态代理类的对象
		IStudent student = (IStudent)ps.getObject();
		student.add();
	}
}






