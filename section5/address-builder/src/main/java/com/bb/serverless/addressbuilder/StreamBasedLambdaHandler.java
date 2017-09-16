package com.bb.serverless.addressbuilder;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class StreamBasedLambdaHandler implements RequestStreamHandler {

    private static Builder builder = new Builder();

    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException{
        String env = System.getenv("CURRENT_ENV");

        LambdaLogger logger = context.getLogger();

        if (logger != null) {
            if (StringUtils.isNotBlank(env)) {
                logger.log("The current env is " + env);
            } else {
                logger.log("CURRENT_ENV is not defined");
            }
        }
        int byteRead = -1;

        while ((byteRead = inputStream.read()) != -1) {
            outputStream.write(Character.toUpperCase(byteRead));
        }
    }
}
