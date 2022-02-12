package com.example.ConsumerProducer;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientPactTest {

    @Autowired
    Client client;

    // This sets up a mock server that pretends to be our provider
    @Rule
    public PactProviderRule mockProvider=new PactProviderRule("CatFactProvider",this);

    // This defines the expected interaction for out test
    @Pact(consumer="CatFactConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder)
    {

        return builder
                .given("")
                .uponReceiving("a request for getJson")
                    .path("/fact")
                    .queryParameterFromProviderState("max_width","","100")
                    .headers("accept","application/json","X-CSRF-TOKEN","wf4PDSKLdtSkYkAu0xYqiQc8uzIEC86QnMZ4eiQb")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(
                            new PactDslJsonBody()
                            .stringValue("fact","any_cat_fact")
                             .stringValue("length","2")
                    ).toPact();
    }

    @Test
    @PactVerification
    public void pactWithOurProvider() throws Exception
    {
       System.out.println("Server Started At:" + mockProvider.getUrl());
        //Sending Request to our Mock Server created by Pact is Important to Generate a PACT
        JSONObject res=client.fun(mockProvider.getUrl()+"/fact?max_width=100");
        //Asserting that  MockServer Set Up by PACT is returning Correct Details ,
        //this is important otherwise a wrong a PACT could be generated
        Assert.assertEquals(res.get("fact"),"any_cat_fact");
        Assert.assertEquals(res.get("length"),"2");

    }

}
