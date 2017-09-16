package com.bb.serverless.prodcatalogv2;

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

        if (input.containsKey("requestContext")) {
            Map<String, Object> requestContext = (Map<String, Object>) input.get("requestContext");
            if (requestContext.containsKey("authorizer")) {
                log.info("Authorizer info: " + requestContext.get("authorizer"));
            }
        }

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        ApiGatewayResponse response = router.routeRequest(input);
        response.setHeaders(headers);

        return response;
    }
}

//handler name: com.bb.serverless.prodcatalogv2.ApiGatewayLambdaHandler
