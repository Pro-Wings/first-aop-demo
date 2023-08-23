package com.prowings.service;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	
	public void print()
	{
		System.out.println("inside print method!!!");
	}
	
	public void addition(int a, int b)
	{
		System.out.println("inside addition (int int )method!!");
		System.out.println("Addition is : "+ (a+b));
	}

	public void addition(long a, long b)
	{
		System.out.println("inside addition(long long) method!!");
		System.out.println("Addition is : "+ (a+b));
		throw new ArithmeticException();
	}

	public Integer sum(int a, int b) throws InterruptedException
	{
		System.out.println("inside sum method!!");
		
		Thread.sleep(5000);
		return a + b;
	}

}
