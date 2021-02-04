package com.webwork.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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

	// this is where we add all related advices for logging

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
