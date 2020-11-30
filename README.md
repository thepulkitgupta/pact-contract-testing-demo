# Pact JAVA 
 # What is Pact? 
> Pact is a code-first tool for testing HTTP and message integrations using contract tests. Contract tests assert that inter-application messages conform to a shared understanding that is documented in a contract. Without contract testing, the only way to ensure that applications will work correctly together is by using expensive and brittle integration tests.  
 # What is contract testing?
> Contract testing is a technique for testing an integration point by checking each application in isolation to ensure the messages it sends or receives conform to a shared understanding that is documented in a "contract".  

# What's happening in the project? 
1. First, a pact will be created.
2. Last, pact will be verified.

### There are 3 files that are important:-
 #### 1. Controller.java (/src/main/java/com/example/ConsumerProducer)
- This class is the main server or API which will accept a GET request at **/getJson** and will return the response as given below in JSON format.
    **{"name":"Tiklup","age":"20"}**
- To run this server, fire up a terminal and type  **gradlew bootrun**

#### 2. Client.java (/src/main/java/com/example/ConsumerProducer)
- This class is the consumer of the controller. There's a method named **fun(String url)** which  
will send the request on the **url** and print the body.

#### 3. ClientPactTest.java (/src/test/java/com/example/ConsumerProducer)
- This is the crux of this whole project.This class will do the following three things.
1. Start a mock server using PactProviderRule.
2. Define a pact with **createPact()** and specify the interactions that will take place on the mock server.
3. Send a request to the mockserver (using **fun()**) through **pactWithOurProvider()** and create a pact file. 

#### Pacts generated will be located in the pacts folder.(/build/pacts/)

## First Step 
- Go to Test class and start the test execution. A pact will be created in the pacts folder.

## Last Step :P
1. Open a terminal and start the server as explained above.
2. Open another terminal and type **gradlew pactverify**.
   This will run the pact file against the server to check whether the response of the interactions specified in the pact, is same as the response which is returned from the actual server.
3. In the terminal it can be confirmed that the status code and the body matches the expected response.

## Conclusion 
By completeing above steps it can be seen how a pact is generated and how to verify it. 
This is a very simple example of using Pact for Integration Testing. 
Please read the official documentation to learn more about **Pact**.

## Useful Links
(https://docs.pact.io/)
(https://github.com/DiUS/pact-workshop-jvm)





