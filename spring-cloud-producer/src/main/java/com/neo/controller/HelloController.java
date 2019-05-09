package com.neo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
    @Autowired
	private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    public String index() {
        return "This is Producer!";
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }

    @RequestMapping("/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
}