package com.bb.serverless.hellojava;

import com.amazonaws.services.lambda.runtime.Context;


public class LambdaHandler {

    public boolean execute(String name, Context context) {
        String ret = null;
        if (name != null && name.trim().length() > 0) {
            ret = "Hello World, I'm " + name + " from lambda";
        } else {
            ret = "Hello World, I'm a nameless person from lambda";
        }
        System.out.println(ret);
        return true;
    }
}
//com.bb.serverless.hellojava.LambdaHandler::execute