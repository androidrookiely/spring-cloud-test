package com.example.msprovideruser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.Entity.User;
import com.example.msprovideruser.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.converters.Auto;

/**
 *创建者:liyang【loken.li@mail.dealmoon.com】
 *创建时间:2018/4/30  下午9:28
 *描述:
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Qualifier("eurekaClient")
    private EurekaClient eclient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value(("${spring.cloud.client.ipAddress}"))
    private String ipAddress;
    
    @GetMapping("/simple/{id}")
    public User findUserById(@PathVariable Long id) {
        System.out.println("findUserByid id:" + id);
        User one = userRepository.findOne(id);

        return one;
    }

    @GetMapping("/eureka-instance")
    public InstanceInfo serviceUrl() {
        InstanceInfo instanceInfo = eclient.getNextServerFromEureka("UNKNOWN",false);
        return instanceInfo;
    }

    @GetMapping("/eureka-info")
    public ServiceInstance showServiceInfo() {
        ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
        return localServiceInstance;
    }

    @GetMapping("/application-name")
    public String getApplicationName() {
        return applicationName;
    }

    @GetMapping("/ipaddress")
    public String getIpAddress() {
        return ipAddress;
    }
}
