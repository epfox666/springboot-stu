package com.epfox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource(value = "classpath:user.properties")
public class User {
    //直接使用@value
    @Value("${user1.name}") //从配置文件中取值
    private String name;
    @Value("#{9*2}") // #{SPEL} Spring表达式
    private int age;
    @Value("男") // 字面量
    private String sex;
}

