package com.prowings.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.prowings.config.SpringConfiguration;
import com.prowings.service.Calculator;

public class TestAop {
	
	public static void main(String[] args) throws InterruptedException {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		
		Calculator calc = ctx.getBean(Calculator.class);
		
//		calc.addition(10L, 20L);
		Integer res = calc.sum(10, 20);
	}

}
