package com.epfox;

import com.epfox.pojo.Dog;
import com.epfox.pojo.Person;
import com.epfox.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
    @Autowired
    Dog dog;
    @Autowired
    Person person;
    @Autowired
    User user;
    @Test
    void contextLoads() {
//        System.out.println(dog.toString());
        System.out.println(person.toString());
//        System.out.println(user.toString());
    }

}
