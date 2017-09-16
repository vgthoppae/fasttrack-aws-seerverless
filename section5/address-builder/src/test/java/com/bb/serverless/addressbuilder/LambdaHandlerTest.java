package com.bb.serverless.addressbuilder;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LambdaHandlerTest {

    @Test
    public void executeWithAll() {

        LambdaHandler lambdaHandler = new LambdaHandler();
        Context context = new MockAWSContext();

        Address address = new Address();
        address.setStreetNumber("1398");
        address.setAddressLineOne("Bruce Blvd");
        address.setAddressLineTwo("Apt 249");
        address.setCity("Wheatland");
        address.setState("VA");
        address.setZip("20198");

        String fullAddress = lambdaHandler.handleRequest(address, context);

        assertTrue(fullAddress != null);
    }

    @Test
    public void executeWithPartial() {

        LambdaHandler lambdaHandler = new LambdaHandler();
        Context context = new MockAWSContext();

        Address address = new Address();
        address.setCity("Wheatland");
        address.setState("VA");
        address.setZip("20198");

        String fullAddress = lambdaHandler.handleRequest(address, context);

        assertTrue(fullAddress != null);
    }
}
