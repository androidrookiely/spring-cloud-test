package com.example.msprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan(basePackages = {"com.example.common.Entity"})
@EnableEurekaClient
public class MsProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProviderUserApplication.class, args);
    }
}
