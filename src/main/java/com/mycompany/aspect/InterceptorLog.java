package com.mycompany.aspect;

import java.lang.reflect.Method;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.MethodBeforeAdvice;


@Aspect
public class InterceptorLog implements MethodBeforeAdvice {

    @Override
    public void before(Method arg0, Object[] arg1, Object arg2)
            throws Throwable {
        System.out.println("Uzeta vrednost je : " + arg0.getName());
    }
}
