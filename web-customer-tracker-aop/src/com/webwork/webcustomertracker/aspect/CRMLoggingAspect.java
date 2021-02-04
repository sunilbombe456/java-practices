package com.webwork.webcustomertracker.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	// set up Logger

	private Logger myLogger = Logger.getLogger(getClass().getName());

	// set up pointcut declaration

	@Pointcut("execution(* com.webwork.webcustomertracker.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.webwork.webcustomertracker.service.impl.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.webwork.webcustomertracker.dao.impl.*.*(..))")
	private void forDaoPackage() {
	}

	// combine @Pointcut Expression

	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
	}

	// Add @Before Advice
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint theJoinPoint) {

		String theMethod = theJoinPoint.getSignature().toShortString();

		// display method we are calling

		myLogger.info("\n ====>>> in @Before we are Calling method: " + theMethod);

		// display the argument to the method

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs : args) {
			myLogger.info("\n =======> Arguments: " + tempArgs);
		}
	}

	// Add @AfterReturning Advice

	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturningAdvice(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>> in @AfterReturning we are Calling method: " + theMethod);
		// display the data returned..!
		myLogger.info("\n =======> Result: " + theResult);

	}

}
