package com.bb.serverless.prodcatalogv1;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

/**
 * Created by vgthoppae on 6/10/17.
 */
public class LambdaHandlerTest {

    @Test
    public void getProdCategories() {
        ApiGatewayLambdaHandler handler = new ApiGatewayLambdaHandler();

        Map<String, Object> request = new HashMap<String, Object>();
        Context context = new MockAWSContext();

        ApiGatewayResponse response = handler.handleRequest(request, context);

        System.out.println(response);
        assertTrue(response != null);
    }
}
