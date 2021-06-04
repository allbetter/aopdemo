package com.example.aspect.aopdemo;

import com.example.aspect.aopdemo.service.HelloService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("com.example.aspect")
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
@SpringBootApplication
public class AopdemoApplication {
//    @Autowired
//    HelloService helloService;

    public static void main(String[] args) {
//        SpringApplication.run(AopdemoApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopdemoApplication.class);
        HelloService helloService = context.getBean(HelloService.class);

        helloService.sayHi("hi-1");
        System.out.println("\n");
        helloService.anotherSayHi("hi-2");
        System.out.println("\n");
        helloService.anotherSayHiNew1("hi-new-1");
        System.out.println("\n");
        helloService.anotherSayHiNew2("hi-new-2");
        System.out.println("\n");
        helloService.anotherSayHiNew3("hi-new-3");

        System.out.println(helloService.increase(1,2));

    }


}
