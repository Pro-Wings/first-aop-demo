package com.prowings.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
//@ComponentScan(basePackages = "com.prowings",
//excludeFilters = {@ComponentScan.Filter(Aspect.class)})

@ComponentScan(basePackages = "com.prowings")
public class SpringConfiguration {
	
	

}
