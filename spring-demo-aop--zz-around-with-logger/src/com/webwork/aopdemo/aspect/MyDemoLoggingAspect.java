package com.webwork.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.webwork.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.webwork.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		// print out method we are Advicing on

		String method = theProceedingJoinPoint.getSignature().toShortString();

		myLogger.info("Executing @Arounf method on" + method);

		// let Begin timeStamp

		long begin = System.currentTimeMillis();

		// now lets execute the method

		Object result = theProceedingJoinPoint.proceed();

		// get the ending timeStamp

		long end = System.currentTimeMillis();

		// complete duration and display it

		long duration = end - begin;

		myLogger.info("\n Duration is =====>" + duration);

		return result;
	}

	@After("execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterfinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n =========> Executing @After (Finally) on method " + method);
	}

	@AfterThrowing(pointcut = "execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))", throwing = "theExe")
	public void afterThrowingAddAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {

		// printout which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ======>> Executing @AfterThrowing on Method :::" + method);
		// log the exception

		myLogger.info("\n ======>> Exception :::" + theExe);

	}
	// this is where we add all related advices for logging
	// add new Advice form @AfterReturning on the FindAccounts Method

	@AfterReturning(pointcut = "execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are Advicing
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ======>> Executing @AfterReturning on Method :::" + method);
		// printout out the result of the Method called

		myLogger.info("\n ======>> Result:::" + result);

		// lets processv the....lets data modify

		convertAccountNameToUpperCase(result);

	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub

		for (Account temp : result) {
			// getUppeerCAse VErsion of name

			String accountName = temp.getName().toUpperCase();

			// Update the Name On Account

			temp.setName(accountName);
		}

	}

	// lets start with an @Before advice

	@Before("com.webwork.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n ===========>>> Executing @Before advice on AddAccount()");

		// display the methiod signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("\n ==>> Method: " + theMethodSignature);

//		display method arguments

//		get args

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs : args) {
			myLogger.info("Arguments" + tempArgs.toString());

			if (tempArgs instanceof Account) {

				Account theAccount = (Account) tempArgs;

				myLogger.info("Account Name is: " + theAccount.getName());
				myLogger.info("Service code is: " + theAccount.getServiceCode());
			}
		}
	}

}
