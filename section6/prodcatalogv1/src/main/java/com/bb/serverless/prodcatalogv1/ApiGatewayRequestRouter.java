package com.bb.serverless.prodcatalogv1;

import com.bb.serverless.prodcatalogv1.processor.ProductCategoryProcessor;

import java.util.Map;

public class ApiGatewayRequestRouter {

    private static final ProductCategoryProcessor prodCategoryProcessor = new ProductCategoryProcessor();

    public Object routeRequest(Map<String, Object> request) {
        return prodCategoryProcessor.getAllProductCategories();

    }
}
