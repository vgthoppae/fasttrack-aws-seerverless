package com.bb.serverless.bloomauth;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.Map;

public class ApiAuthorizer implements RequestHandler<Map<String, Object>, AuthPolicy> {

    private static final Logger log = Logger.getLogger(ApiAuthorizer.class);

    private static final String STD_USER = "Bloomer";

    public AuthPolicy handleRequest(Map<String, Object> input, Context context) {

        //Read the three input fields
        String token = (String) input.get("authorizationToken"); //bearer token
        String methodArn = (String) input.get("methodArn"); //arn:aws:execute-api:us-east-1:698225460402:6czcct1900/dev/GET/1
        String type = (String) input.get("type"); //TOKEN

        //stop right here if there is no token
        if (StringUtils.isBlank(token)) {
            log.info("Request received with no token");
            throw new RuntimeException("Unauthorized Request - Authorization token is expected");
        }
        String message = String.format("Request received with type:%s, authorizationToken:%s, methodArn:%s", type, token, methodArn);
        log.info(message);

        //Validate the token with any preferred mechanism and extract the principal Id from the token
        String principalId = STD_USER;

        //parse the method Arn for region, AWS account id, rest API id and stage
        String[] arnPartials = methodArn.split(":");
        String region = arnPartials[3];
        String awsAccountId = arnPartials[4];
        String[] apiGatewayArnPartials = arnPartials[5].split("/");
        String restApiId = apiGatewayArnPartials[0];
        String stage = apiGatewayArnPartials[1];

//        String httpMethod = apiGatewayArnPartials[2];
//        String resource = ""; // root resource
//        if (apiGatewayArnPartials.length == 4) {
//            resource = apiGatewayArnPartials[3];
//        }

        //for demonstration purpose, this code allows all requests with token string of "allow" and rejects otherwise
        //generating policy accordingly
        AuthPolicy.PolicyDocument policyDocument = null;
        if (StringUtils.equals("allow", token)) {
            policyDocument = AuthPolicy.PolicyDocument.getAllowAllPolicy(region, awsAccountId, restApiId, stage);
        } else {
            policyDocument = AuthPolicy.PolicyDocument.getDenyAllPolicy(region, awsAccountId, restApiId, stage);
        }

        AuthPolicy authPolicy = new AuthPolicy(principalId, policyDocument);

        authPolicy.getContext().put("authorizerExecutionTs", new Date());
        authPolicy.getContext().put("permissionNumber", 7);

        //return an AuthPolicy object which has all the elements for AWS to construct a policy
        return authPolicy;
    }
}

//handler: com.bb.serverless.bloomauth.ApiAuthorizer