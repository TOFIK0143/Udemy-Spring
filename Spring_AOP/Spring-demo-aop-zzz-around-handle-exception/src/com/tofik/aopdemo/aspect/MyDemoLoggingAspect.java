package com.tofik.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tofik.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.tofik.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advicing on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin= System.currentTimeMillis();
		
		//now, let's execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			
			// log the exception
			myLogger.warning(e.getMessage());
			
//			// give user a custome message
//			result = "Major accident! But no woories,"
//					+ "your private AOP helicopter is on the way";
			
			// rethrow exception
			throw e;
		}
		
		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n====>>> Duration: " + duration / 1000.0 + "seconds");
		
		return result;
	}
	
	@After("execution(* com.tofik.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @After (finally) on method: " + method);
				
	}
	
	
	@AfterThrowing(
			pointcut="execution(* com.tofik.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
			JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @AfterThrowing on method: " + method);
		
		// log the Exception
		myLogger.info("\n====>>> The exception is: " + theExc);
	}
	
	@AfterReturning(
			pointcut="execution(* com.tofik.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
			JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advicing on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>> Executing @Afterreturning on method: " + method);
		
		// print out the results of the method call
		myLogger.info("\n====>>> result is: " + result);
		
		// let's post-process the data... let's modify it :-)
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts
			for(Account tempAccount : result ) {
				// get uppercase version of name
				String theUpperName = tempAccount.getName().toUpperCase();
				
				// updat ethe name on the account
				tempAccount.setName(theUpperName);
			}
	}





	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice
	
	// @Before("execution(public void addAccount()")
	
	
	@Before("com.tofik.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSign);
		
		// display method arguments
		
		// get args 
		Object[] args = theJoinPoint.getArgs();
		
		// loop throw args
		for(Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
			}
		}
	}

}
