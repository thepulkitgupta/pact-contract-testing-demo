package com.example.ConsumerProducer;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controller {
//This acts as CatFactProvider while doing pactVerification
        @GetMapping("/fact")
        public ResponseEntity getJson(@RequestParam("max_width") String width) {
                HashMap<String,String> hm=new HashMap<>();
                hm.put("fact","All Cats are so Cute");
                hm.put("length","2");
                return ResponseEntity.ok(hm);
        }
}
