package com.example.billing;

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

    public void billUser(String userId, int amount) {
        restTemplate.postForEntity( "//billing/reoccurringPayment", amount, String.class);
    }
}
