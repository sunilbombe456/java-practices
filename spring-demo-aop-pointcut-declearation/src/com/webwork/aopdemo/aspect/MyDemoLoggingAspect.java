package com.webwork.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all related advices for logging
	
	// lets start with an @Before advice
	
	@Pointcut("execution(* com.webwork.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//create point cut for getter method 
	@Pointcut("execution(* com.webwork.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	
	// create point cut for setter method
	@Pointcut("execution(* com.webwork.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut for include package and exclude the getter and setter method
	@Pointcut("forDaoPackage() && !( getter() || setter() )")
	private void forDaoPackageNoGetterAndSetter() {}

	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ===========>>> Executing @Before advice on AddAccount()");
	}
	
	@Before("forDaoPackageNoGetterAndSetter()")
	public void performApiAnalytics() {
		System.out.println("\n ==============>>Performing API Analytics ");
	}
}
