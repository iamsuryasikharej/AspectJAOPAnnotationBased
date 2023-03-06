package com.surya.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAspects {
	@Before("execution(* com.surya.services.DemoService.*(..))")
	public void before(JoinPoint jp)
	{
		System.out.println("before==> method calling"+jp.getSignature().getName());
	}
	@After("execution(* com.surya.services.DemoService.*(..))")
	public void after(JoinPoint jp)
	{
		System.out.println("after==> method calling"+jp.getSignature().getName());
	}
	@Around("execution(* com.surya.services.DemoService.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println(" around====>before method calling with method name-->"+pjp.getSignature().getName());
		pjp.proceed();
		System.out.println("around====>after method calling with method name-->"+pjp.getSignature().getName());
	}
	@AfterThrowing(pointcut="execution(* com.surya.services.DemoService.*(..))",throwing="throwable")
	public void afterThrowing(JoinPoint jp,Throwable throwable) throws Throwable
	{
		System.out.println("afterthrowing  ====>an exception has occured in method-->"+jp.getSignature().getName()+"and name of the exception is"+throwable.getMessage());
		
		
	}
	@AfterReturning(pointcut="execution(* com.surya.services.DemoService.*(..))",returning="result")
	public void afterReturning(JoinPoint jp,Object result)
	{
		System.out.println("for method"+jp.getSignature().getName()+"result obj returned"+result);
	}


}
