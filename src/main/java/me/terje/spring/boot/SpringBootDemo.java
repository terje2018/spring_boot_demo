package me.terje.spring.boot;


import me.terje.spring.restful.HeartBeatRestFul;
import me.terje.spring.restful.OrderRestful;
import org.springframework.boot.SpringApplication;

/**
 * logback.xml会自动加载。
 *
 * */
public class SpringBootDemo {
    public static void main(String[] args) {
        Class[] clazz = {OrderRestful.class, HeartBeatRestFul.class};
        SpringApplication.run(clazz, args);

    }
}
