package com.prowings.aspects;

import java.util.concurrent.TimeUnit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalcLoggingAspect {

	@Pointcut("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void mypointcut()
	{}

	@Before("mypointcut()")
	public void logBeforeAddition(JoinPoint joinPoint) {
		System.out.println("logBefore addition() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterReturning("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterReturningAddition(JoinPoint joinPoint) {
		System.out.println("log after returning addition() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@AfterThrowing("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterThrowingAddition(JoinPoint joinPoint) {
		System.out.println("log after throwing addition() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@After("execution(* com.prowings.service.Calculator.addition(long,long))")
	public void logAfterAddition(JoinPoint joinPoint) {
		System.out.println("log after addition() is running!");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

	@Around("execution(* com.prowings.service.Calculator.sum(..))")
	public void logAroundSum(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("****LoggingAspect.logAroundMethod() - Before method call");
        
        long start = System.nanoTime();
        Integer result = (Integer) pjp.proceed();
        System.out.println("method returened value --->>> "+result);
        long end = System.nanoTime();
        String methodName = pjp.getSignature().getName();
        System.out.println("Execution of " + methodName + " took " + 
          TimeUnit.NANOSECONDS.toMillis(end - start) + " ms");

        System.out.println("****LoggingAspect.logAroundMethod() - After method call");
		
	}

	
	
}
