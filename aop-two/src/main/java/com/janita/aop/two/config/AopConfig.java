package com.janita.aop.two.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Janita on 2017-03-22 09:43
 */
@Configuration
@ComponentScan("com.janita")
@EnableAspectJAutoProxy
public class AopConfig {
}
