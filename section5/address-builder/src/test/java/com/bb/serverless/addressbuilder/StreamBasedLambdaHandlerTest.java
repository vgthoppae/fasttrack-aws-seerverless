package com.bb.serverless.addressbuilder;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by vgthoppae on 5/30/17.
 */
public class StreamBasedLambdaHandlerTest {

    @Test
    public void handleRequest() {
        StreamBasedLambdaHandler handler =  new StreamBasedLambdaHandler();
        MockAWSContext context = new MockAWSContext();

        String str = "Here is the stream";
        String upperStr = str.toUpperCase();

        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();

        try {
            handler.handleRequest(inputStream, outputStream, context);
            String ret = outputStream.toString();
            System.out.println(ret);
            assertTrue(ret.equals(upperStr));
        } catch (IOException e) {
            fail("test failed");
        }
    }
}
