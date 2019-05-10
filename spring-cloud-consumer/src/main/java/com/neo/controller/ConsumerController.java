package com.neo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
	private DiscoveryClient discoveryClient;
    
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
        return "This is Consumer!";
    }

    @RequestMapping("/call")
    public String call() {
        String result="调用spring-cloud-producer得到的返回结果:<br>";
        result+=restTemplate.getForEntity("http://spring-cloud-producer/", String.class).getBody();
        return result;
    }

    @RequestMapping("/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
}