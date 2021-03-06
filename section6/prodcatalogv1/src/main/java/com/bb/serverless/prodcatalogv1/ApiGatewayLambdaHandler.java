package com.bb.serverless.prodcatalogv1;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;


public class ApiGatewayLambdaHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger log = Logger.getLogger(ApiGatewayLambdaHandler.class);

    private static final ApiGatewayRequestRouter router = new ApiGatewayRequestRouter();

    public ApiGatewayResponse handleRequest(Map<String, Object> input, Context context) {
        log.info("received: " + input);

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        Object responseBody = router.routeRequest(input);

        ApiGatewayResponse response = new ApiGatewayResponse(200, responseBody, headers);

        return response;
    }
}

//handler name: ApiGatewayLambdaHandler
