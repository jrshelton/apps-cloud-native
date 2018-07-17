package com.example.billing;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

public class Client {

    private final RestOperations restTemplate;
    //private final String serviceEndpoint;

    //public Client(String serviceEndpoint) {
      //  this.restTemplate = new RestTemplate();
        //this.serviceEndpoint = serviceEndpoint;
    //}

    public Client(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "billUserFallback")
    public void billUser(String userId, int amount) {
        restTemplate.postForEntity( "//billing/reoccurringPayment", amount, String.class);
    }


    void billUserFallback(String userId, int amount) {
        System.out.println("Executing fallback method for user: " + userId + " and amount: " + amount);
    }
}
