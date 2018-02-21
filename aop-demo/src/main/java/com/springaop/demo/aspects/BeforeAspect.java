package com.springaop.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
public class BeforeAspect {

    private Logger logger = Logger.getLogger(BeforeAspect.class.getName());

    @Pointcut("execution(* com.springaop.demo.processor.PrintInterface.printLoop())")
    public void printMethod(){
    }

    @Before("printMethod()")
    public void logMethodCall(JoinPoint jp){
        logger.info("Before:: "+jp.getSignature().getName());
    }
}
