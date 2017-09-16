package com.bb.serverless.hellojava;

import com.amazonaws.services.lambda.runtime.Context;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class LambdaHandlerTest {

    @Test
    public void happyExecuteWithName() {

        LambdaHandler lambdaHandler = new LambdaHandler();
        Context context = new MockAWSContext();

        boolean ret = lambdaHandler.execute("Anamika", context);

        assertTrue(ret);
    }

    @Test
    public void happyExecuteWithNoName() {

        LambdaHandler lambdaHandler = new LambdaHandler();
        Context context = new MockAWSContext();

        boolean ret = lambdaHandler.execute(null, context);

        assertTrue(ret);
    }
}
