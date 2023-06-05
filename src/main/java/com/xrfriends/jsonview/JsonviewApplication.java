package com.xrfriends.jsonview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ ApplicationProperties.class })
public class JsonviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonviewApplication.class, args);
    }

}
