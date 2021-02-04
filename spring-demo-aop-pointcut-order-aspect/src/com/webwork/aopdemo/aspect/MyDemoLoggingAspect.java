package com.webwork.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	// this is where we add all related advices for logging

	// lets start with an @Before advice

	@Before("com.webwork.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ===========>>> Executing @Before advice on AddAccount()");
	}

}
