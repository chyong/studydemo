package com.song.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

    @Pointcut("execution(* com.song.service.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){


    }

}
