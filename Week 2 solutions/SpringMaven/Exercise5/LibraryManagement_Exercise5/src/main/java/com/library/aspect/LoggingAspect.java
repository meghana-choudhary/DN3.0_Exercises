package com.library.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	//logger object to log the updates
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	//adding the before advice fired on all the methods of service
		@Before("execution(* com.library.service.*.*(..))")
	public void before(JoinPoint jointPoint) {
		System.out.println("Before...");
		logger.info("before method execution");
		System.out.println(jointPoint.getSignature().getName());
	}
	
	@After("execution(* com.library.service.*.*(..))")
	public void after(JoinPoint jointPoint) {
		System.out.println("After...");
		logger.info("after method execution");
		System.out.println(jointPoint.getSignature().getName());
	}

//	
//	@Around("execution(* com.library.service.*.*(..))")
//	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//		long startTime=System.currentTimeMillis();
//		System.out.println(joinPoint.getSignature().getName()+" starts at " + startTime + " milli seconds");
//		Object proceed = joinPoint.proceed();
//		long endTime=System.currentTimeMillis();
//		System.out.println(joinPoint.getSignature().getName()+" ends at " + endTime + " milli seconds");
//		long execTime = endTime - startTime;
//		System.out.println(joinPoint.getSignature()+" takes " + execTime + " ms to complete execution!");
//		return proceed;
//	
//	}
}
