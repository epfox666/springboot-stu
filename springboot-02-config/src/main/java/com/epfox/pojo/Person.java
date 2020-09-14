package com.epfox.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource(value = "classpath:person.properties")
@Validated
public class Person {
//    @Email(message="邮箱格式错误") //name必须是邮箱格式
    private String lastName;
    private int age;
    private List<Object> lists;
    private Map<String,Object> maps;
    private boolean marry;
    private Dog dog;
    private Date birth;
    private String hello;
}
