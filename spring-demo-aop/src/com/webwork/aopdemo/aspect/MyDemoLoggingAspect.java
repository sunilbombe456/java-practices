package com.webwork.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all related advices for logging
	
	// lets start with an @Before advice
	
//	@Before("execution(* add*())")
	@Before("execution(* com.webwork.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ===========>>> Executing @Before advice on AddAccount()");
	}
}
