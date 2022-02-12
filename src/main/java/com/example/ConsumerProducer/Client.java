package com.example.ConsumerProducer;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class Client {

    private final RestTemplate restTemplate;
    HttpHeaders headers;
    HttpEntity<String> entity;
    public Client(RestTemplateBuilder restTemplateBuilder ){
        restTemplate=restTemplateBuilder.build();
        headers = new HttpHeaders();
    }

    public JSONObject fun( String url) throws JSONException {
        System.out.println("Url passed to function is "+ url);
        //Set-Up Header
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-CSRF-TOKEN","wf4PDSKLdtSkYkAu0xYqiQc8uzIEC86QnMZ4eiQb");
        //Create Metadata
        entity=new HttpEntity<>(headers);
        //Using Metadata above to send a Request
        ResponseEntity<String> responseEntity=
                restTemplate.exchange(url, HttpMethod.GET,entity ,String.class);
        //Convert String to JSON Data
        JSONObject jsonResponse = new JSONObject(responseEntity.getBody());
        return jsonResponse;
    }
}