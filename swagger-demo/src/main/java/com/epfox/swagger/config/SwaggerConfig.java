package com.epfox.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2   //开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(Environment environment){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(Environment environment){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(Environment environment){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }

    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("epfox")
                .enable(flag) //enable是否启动Swagger，如果为false，则swagger不能再浏览器中访问
                .select()
                //RequestHandlerSelectors:配置要扫描接口的方式
                //basePackage:执行要扫描的包
                //any():扫描全部
                //none():不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.epfox.swagger.controller"))
                //paths()。过滤什么路径
//                .paths(PathSelectors.ant("/epfox/**"))
                .build();
    }
    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        Contact DEFAULT_CONTACT = new Contact("Epfox", "https://github.com/epfox666/springboot-stu", "274625988@qq.com");
        return new ApiInfo(
                "Epfox Api Documentation",
                "QATesting",
                "v1.0",
                "https://github.com/epfox666/springboot-stu",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
