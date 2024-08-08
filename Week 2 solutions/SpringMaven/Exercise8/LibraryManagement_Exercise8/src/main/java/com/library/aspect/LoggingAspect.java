package com.library.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.aspectj.lang.JoinPoint;

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

		//adding the after advice fired on all the methods of service
		@After("execution(* com.library.service.*.*(..))")
		public void after(JoinPoint jointPoint) {
			System.out.println("After...");
			logger.info("after method execution");
			System.out.println(jointPoint.getSignature().getName());
		}

}

