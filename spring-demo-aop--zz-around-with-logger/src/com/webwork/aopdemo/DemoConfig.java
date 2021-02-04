package com.webwork.aopdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.webwork.aopdemo")
public class DemoConfig {

}
