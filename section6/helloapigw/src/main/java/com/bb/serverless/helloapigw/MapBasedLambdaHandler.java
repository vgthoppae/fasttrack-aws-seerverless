package com.bb.serverless.helloapigw;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MapBasedLambdaHandler implements RequestHandler<Map<String, Object>, Map<String, Object>>{

    private static final Logger log = Logger.getLogger(MapBasedLambdaHandler.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {

        log.info("received: " + input);

        Map<String, Object> output = new HashMap<String, Object>();
        output.put("statusCode", 200);
        output.put("body", convertToJson("Hello API"));

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", "application/json");

        output.put("headers", headers);

        return output;
    }

    private String convertToJson(Object body) {
        try {
            return objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            log.error("Error while serializing body to JSON", e);
            throw new RuntimeException("Failed to convert body to JSON");
        }
    }
}

//handler name: com.bb.serverless.helloapigw.MapBasedLambdaHandler
