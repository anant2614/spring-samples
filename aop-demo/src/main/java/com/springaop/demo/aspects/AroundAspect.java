package com.springaop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class AroundAspect {

    private Logger logger = Logger.getLogger(BeforeAspect.class.getName());

    @Pointcut("execution(* com.springaop.demo.processor.PrintInterface.printLoop())")
    public void calculations(){
    }

    @Around("calculations()")
    public Object calculateMethodExecTime(ProceedingJoinPoint jp) throws Throwable {
        logger.info("Before execution:: ");
        long start = System.currentTimeMillis();
        Object returnVal = jp.proceed();
        long end = System.currentTimeMillis();
        logger.info("Time taken for execution is ::: "+(end-start) + " ms");
        return returnVal;
    }
}
