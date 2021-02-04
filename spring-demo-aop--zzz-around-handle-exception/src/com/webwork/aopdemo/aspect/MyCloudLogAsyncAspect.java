package com.webwork.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

	@Before("com.webwork.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterAndSetter()")
	public void logToCloudeAsync() {
		System.out.println("\n ==============>>Logging to cloude async fashion ");
	}

}
