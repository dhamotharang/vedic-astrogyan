package com.vedic.astro.logging;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.vedic.astro.exception.BusinessException;

/**
 * Aspect for logging debug information.
 * 
 * @author Saxena_s
 * 
 */

@Aspect
public class LoggingAspect {

	protected static Logger logger = Logger.getLogger("controller");

	@Pointcut("execution(* com.vedic.astro.controller..*(..))")
	public void allControllerMethods() {
	}

	@Pointcut("execution(* com.vedic.astro.service..*(..))")
	public void allServiceMethods() {
	}

	@Pointcut("execution(* com.vedic.astro.repository..*(..))")
	public void allRepositoryMethods() {
	}

	@Pointcut("execution(* com.vedic.astro.util..*(..))")
	public void allUtilMethods() {
	}

	@Pointcut("(allControllerMethods()) || (allServiceMethods()) || allRepositoryMethods()")
	public void allMethods() {
	}

	@Before("allMethods()")
	public void logBefore(JoinPoint joinPoint) {

		logger.debug("Entering method "
				+ getClassName(joinPoint.getTarget().toString()) + "."
				+ joinPoint.getSignature().getName() + "() with args "
				+ getArguments(joinPoint.getArgs()));
	}

	/*
	 * @After("allControllerMethods()") public void logAfter(JoinPoint
	 * joinPoint) { logger.debug("Exiting method " +
	 * getClassName(joinPoint.getTarget().toString()) + "." +
	 * joinPoint.getSignature().getName() + "()"); }
	 */

	@AfterReturning(pointcut = "allMethods()", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		logger.debug("Returning from method "
				+ getClassName(joinPoint.getTarget().toString()) + "."
				+ joinPoint.getSignature().getName() + "() with values : "
				+ result);

	}

	@AfterThrowing(pointcut = "allMethods()", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		
		logger.error("Exception thrown from method "
				+ getClassName(joinPoint.getTarget().toString()) + "."
				+ joinPoint.getSignature().getName() + "() ,exception trace : "
				+ error.getMessage());
		if (!(error instanceof BusinessException)) {

			logger.error("Localized message :" + error.getLocalizedMessage());
			logger.error("Cause of exception :"  + error.getCause());

			StackTraceElement[] stackTraces = error.getStackTrace();

			logger.error(error.toString());
			
			if(stackTraces.length > 1){

			logger.error("className: " + stackTraces[0].getClassName()
					+ ", fileName: " + stackTraces[0].getFileName()
					+ ", method name: " + stackTraces[0].getMethodName()
					+ ", line number: " + stackTraces[0].getLineNumber());

			logger.error("className: " + stackTraces[1].getClassName()
					+ ", fileName: " + stackTraces[1].getFileName()
					+ ", method name: " + stackTraces[1].getMethodName()
					+ ", line number: " + stackTraces[1].getLineNumber());

			}
		}
	}

	private String getClassName(String name) {
		StringTokenizer className = new StringTokenizer(name, "@");
		return className.nextToken();

	}

	private String getArguments(Object[] objs) {

		String result = "";
		for (int i = 0; i < objs.length; i++) {
			if (objs[i] != null) {
				result = result + objs[i].toString() + " ";
			}
		}

		if (result.equals("")) {
			result = "none";
		}
		return result;
	}

}