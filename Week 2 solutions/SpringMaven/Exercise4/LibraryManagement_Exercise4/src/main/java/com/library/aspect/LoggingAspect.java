package com.library.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Around("execution(* com.library.service.*.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();
		System.out.println(joinPoint.getSignature().getName()+" starts at " + startTime + " milli seconds");
		Object proceed = joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println(joinPoint.getSignature().getName()+" ends at " + endTime + " milli seconds");
		long execTime = endTime - startTime;
		System.out.println(joinPoint.getSignature()+" takes " + execTime + " ms to complete execution!");
		return proceed;
	
	}
}
