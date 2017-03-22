package com.janita.aop.two;

import com.janita.aop.two.aop.AspectTwo;
import com.janita.aop.two.config.AopConfig;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

/**
 * Created by Janita on 2017-03-22 08:49
 */
@SpringBootApplication
@Import(AopConfig.class)
public class AopTwoApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(AopTwoApplication.class);
    }
    public static void main(String[] args) {
//        APIVersionChecker.check();
        SpringApplication app = new SpringApplication(AopTwoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
