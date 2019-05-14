package com.datagenerator.authservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;




@EnableAsync
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
@EnableResourceServer
@EnableDiscoveryClient
@EnableOAuth2Client
@SpringBootApplication
public class AuthServiceApplication  {
    public static void main(String[] args) {

        SpringApplication.run(AuthServiceApplication.class,args);


    }

}
