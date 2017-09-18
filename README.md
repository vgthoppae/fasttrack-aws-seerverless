# Fast Track AWS Serverless for Developers
This repository contains resources for the the Udemy course at https://www.udemy.com/fast-track-serverless-aws-for-developers/. All the resources that can be downloaded from Udemy for this course are available in this repository.

The contents are explained below.

* *section4/my-inline-policy.json*: An IAM policy that allows to change password for the current IAM user
* *section5/hellojava*: A HelloWorld Java project that can be deployed as an AWS Lambda function
* *section5/address-builder*: A Java project that can be deployed as two different AWS Lambda functions illustrating implementation of *com.amazonaws.services.lambda.runtime.RequestHandler* and *com.amazonaws.services.lambda.runtime.RequestStreamHandler* interfaces
* *section5/lambda-assume-role.json*: An IAM policy for an AWS Lambda to assume an STS role
* *section5/lambda-commands.txt*: Contains AWS CLI commands to
   * Delete a Lambda function
   * Create an IAM role for a Lambda to assume
   * Attach a managed policy to an IAM role
   * Create a Lambda function
   * Update a Lambda function configuration
   * Update a Lambda function code
* *section6/bloomauth*: A Java project that can be deployed as an AWS Lambda function to act as a custom authorizer for API Gateway
* *section6/helloapigw*: A HelloWorld Java project that can be deployed as an AWS Lambda function and integrated with API Gateway
* *section6/prod-catalog-v1.yaml*: The first version of Product Catalog Swagger API
* *section6/prodcatalogv1*: A Java implementation for prod-catalog-v1.yaml that can be deployed as an AWS Lambda function and integrated with API Gateway
* *section6/prod-catalog-v2.yaml*: The second version of Product Catalog Swagger API
* *section6/prodcatalogv1*: A Java implementation for prod-catalog-v2.yaml that can be deployed as an AWS Lambda function and integrated with API Gateway
* *section6/prodcatalogservice*: A Java implementation for prod-catalog-v2.yaml that can be deployed as an AWS Lambda function and integrated with API Gateway as a non-proxy

