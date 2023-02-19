package ir.webapp.springprojectapi.model.common.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPLog {

    private static Log logger = LogFactory.getLog("AOPControllerLog");

    @Pointcut("execution(public * ir.webapp.springprojectapi.controller.app.*.*(..))")
    public void pointCut(){}

    @Around("pointCut()")
    public Object loggingAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //before
        logger.info(String.format(
                "Method %s is called from class %s",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getTarget().getClass().getSimpleName()));

        //continue
        Object returnObj = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());

        //after
        logger.info(String.format(
                "Method %s is called from class %s and the return value is: %s",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                returnObj.getClass().getName()));

        return returnObj;
    }

//    @Before("pointCut()")
//    public void loggingBeforeAdvice()
//    {
//        System.out.println("Before advice is executed");
//    }
//
//    @After("pointCut()")
//    public void loggingAfterAdvice()
//    {
//        System.out.println("Running After Advice.");
//    }
//
//    // runs before and after
//    @Around("pointCut()")
//    public void loggingAroundAdvice()
//    {
//        System.out.println("Before and After invoking method");
//    }
//
//    @AfterThrowing("pointCut()")
//    public void loggingAfterThrowingAdvice()
//    {
//        System.out.println("Exception thrown in method");
//    }
//
//    @AfterReturning("pointCut()")
//    public void loggingAfterReturningAdvice()
//    {
//        System.out.println("AfterReturning advice is run");
//    }
}
