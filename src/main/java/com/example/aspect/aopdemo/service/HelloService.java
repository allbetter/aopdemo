package com.example.aspect.aopdemo.service;

import com.example.aspect.aopdemo.aspect.Log;
import javafx.application.Application;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
public class HelloService {

    @Log
    public int increase(int a, int b) {return  a+b;}

    @Log
    public void sayHi(String msg) {
        System.out.println("\tsayHi:" + msg);
    }

    public void anotherSayHi(String msg) {
        this.sayHi(msg);
    }

    //方法一
    @Autowired
    private HelloService helloService;
    public void anotherSayHiNew1(String msg) {
        helloService.sayHi(msg);
    }

    //方法二
    @Autowired
    private ApplicationContext applicationContext;

    public void anotherSayHiNew2(String msg) {
        applicationContext.getBean(HelloService.class).sayHi(msg);
    }

    //方法三
    public void anotherSayHiNew3(String msg) {
        HelloService helloService = (HelloService) AopContext.currentProxy();
        helloService.sayHi(msg);
    }

}
