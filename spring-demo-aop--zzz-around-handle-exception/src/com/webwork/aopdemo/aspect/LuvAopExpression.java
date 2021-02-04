package com.webwork.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LuvAopExpression {

	@Pointcut("execution(* com.webwork.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// create point cut for getter method
	@Pointcut("execution(* com.webwork.aopdemo.dao.*.get*(..))")
	public void getter() {
	}

	// create point cut for setter method
	@Pointcut("execution(* com.webwork.aopdemo.dao.*.set*(..))")
	public void setter() {
	}

	// create pointcut for include package and exclude the getter and setter method
	@Pointcut("forDaoPackage() && !( getter() || setter() )")
	public void forDaoPackageNoGetterAndSetter() {
	}

}
