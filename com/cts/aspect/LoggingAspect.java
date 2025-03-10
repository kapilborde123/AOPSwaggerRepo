package com.cts.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.cts.controller.*.*(..))")
	public void logRequest() {
		System.out.println("API request received");
	}
}
