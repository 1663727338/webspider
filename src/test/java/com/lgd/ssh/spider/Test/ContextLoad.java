package com.lgd.ssh.spider.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoad {

	public static void loadContext(){
		new ClassPathXmlApplicationContext("spring/*.spring.xml");
	}
}
