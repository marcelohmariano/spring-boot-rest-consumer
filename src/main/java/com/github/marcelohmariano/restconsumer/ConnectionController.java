package com.github.marcelohmariano.restconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConnectionController {

    private final RestTemplate restTemplate;

    @Autowired
    public ConnectionController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/")
    public ConnectionData index() {
        return restTemplate.getForObject("https://api.myip.com", ConnectionData.class);
    }
}
