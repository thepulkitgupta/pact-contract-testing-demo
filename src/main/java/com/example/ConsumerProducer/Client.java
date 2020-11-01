package com.example.ConsumerProducer;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class Client {


    RestTemplate restTemplate=new RestTemplate();

    public JSONObject fun( String url)
    {

      JSONObject resJson=new JSONObject(restTemplate.getForObject(url, String.class));
      System.out.println("Name is : "+resJson.get("name") +"\nAge is : "+resJson.get("age"));
      return resJson;

    }

}
