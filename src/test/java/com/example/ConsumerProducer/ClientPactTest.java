package com.example.ConsumerProducer;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.json.JSONObject;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientPactTest {

    @Autowired
    Client client;

    // This sets up a mock server that pretends to be our provider
    @Rule
    public PactProviderRule mockProvider=new PactProviderRule("ExampleProvider",this);


    private String name;
    private String age;

    // This defines the expected interaction for out test
    @Pact(consumer="ExampleConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder)
    {
        name="Tiklup";
        age="2";
        return builder
                .given("")
                .uponReceiving("a request for getJson")
                .path("/getJson")
                .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(
                            new PactDslJsonBody()
                            .stringValue("name","Tiklup")
                            .stringValue("age","02")
                    ).toPact();
    }

    @Test
    @PactVerification
    public void pactWithOurProvider() throws Exception
    {
       System.out.println("Server Started At:" + mockProvider.getUrl());

        JSONObject res=client.fun(mockProvider.getUrl()+"/getJson");

        assertThat(res.get("name")).isEqualTo("Tiklup");
        assertThat(res.get("age")).isEqualTo("02");


    }

}
