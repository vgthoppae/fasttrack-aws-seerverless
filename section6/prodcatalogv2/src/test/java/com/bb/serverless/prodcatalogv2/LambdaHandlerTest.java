package com.bb.serverless.prodcatalogv2;

import com.amazonaws.services.lambda.runtime.Context;
import com.bb.serverless.prodcatalogv2.ApiGatewayLambdaHandler;
import com.bb.serverless.prodcatalogv2.ApiGatewayResponse;
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

        request.put("httpMethod", "GET");
        request.put("resource", "/");

        ApiGatewayResponse response = handler.handleRequest(request, context);

        System.out.println(response);
        assertTrue(response != null);
    }

    @Test
    public void getProductsByProdCategoryId() {
        ApiGatewayLambdaHandler handler = new ApiGatewayLambdaHandler();

        Map<String, Object> request = new HashMap<String, Object>();
        Context context = new MockAWSContext();

        request.put("httpMethod", "GET");
        request.put("resource", "/{product_category_id}");

        Map<String, Object> pathParameters = new HashMap<String, Object>();
        pathParameters.put("product_category_id", "1");

        request.put("pathParameters", pathParameters);

        Map<String, Object> queryStringParameters = new HashMap<String, Object>();
        queryStringParameters.put("page_size", 10);
        queryStringParameters.put("page", 0);

        request.put("queryStringParameters", queryStringParameters);

        ApiGatewayResponse response = handler.handleRequest(request, context);

        System.out.println(response);
        assertTrue(response != null);
    }
}
