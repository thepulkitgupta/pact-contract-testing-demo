package com.example.ConsumerProducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {

        @GetMapping("/getJson")
        public HashMap<String,String> getJson() {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("name","Tiklup");
                hm.put("age","02");
                return hm;
        }
}
