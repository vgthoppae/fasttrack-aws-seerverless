package com.bb.serverless.addressbuilder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class LambdaHandler implements RequestHandler<Address, String>{

    private static final Logger log = Logger.getLogger(LambdaHandler.class);

    private static Builder builder = new Builder();

    public String handleRequest(Address input, Context context) {
        log.debug("Request received with input:" + input.toString());

        builder.execute(input);

        String env = System.getenv("CURRENT_ENV");

        if (StringUtils.isNotBlank(env)) {
            log.debug("The current env is " + env);
        } else {
            log.debug("CURRENT_ENV is not defined");
        }

        log.debug(input.getFullAddress());

        return input.getFullAddress();
    }
}

//Handler configuration value -> com.bb.serverless.addressbuilder.LambdaHandler
