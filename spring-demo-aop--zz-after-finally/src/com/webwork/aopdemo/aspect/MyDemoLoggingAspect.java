package com.webwork.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	

	@After("execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))")
	public void afterfinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n =========> Executing @After (Finally) on method "+ method);
	}

	@AfterThrowing(pointcut ="execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))",
			throwing = "theExe")
	public void afterThrowingAddAccountAdvice(JoinPoint theJoinPoint, Throwable theExe) {
		
		//printout which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ======>> Executing @AfterThrowing on Method :::" + method);
		//log the exception
		
		System.out.println("\n ======>> Exception :::" + theExe);
		
	}
	// this is where we add all related advices for logging
	//add new Advice form @AfterReturning on the FindAccounts Method
	
	@AfterReturning(pointcut="execution(* com.webwork.aopdemo.dao.AccountDao.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		// print out which method we are Advicing
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ======>> Executing @AfterReturning on Method :::" + method);
		// printout out the result of the Method called
		
		System.out.println("\n ======>> Result:::" + result);
		
		//lets processv the....lets data modify
		
		convertAccountNameToUpperCase(result);

	}
	

	private void convertAccountNameToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		
		for(Account temp: result)
		{
			// getUppeerCAse VErsion of name
			
			String accountName = temp.getName().toUpperCase();
			
			//Update the Name On Account
			
			temp.setName(accountName);
		}
		
	}


	// lets start with an @Before advice

	@Before("com.webwork.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n ===========>>> Executing @Before advice on AddAccount()");

		// display the methiod signature
		MethodSignature theMethodSignature = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("\n ==>> Method: " + theMethodSignature);

//		display method arguments

//		get args

		Object[] args = theJoinPoint.getArgs();

		for (Object tempArgs : args) {
			System.out.println("Arguments" + tempArgs);

			if (tempArgs instanceof Account) {

				Account theAccount = (Account) tempArgs;

				System.out.println("Account Name is: " + theAccount.getName());
				System.out.println("Service code is: " + theAccount.getServiceCode());
			}
		}
	}

}
