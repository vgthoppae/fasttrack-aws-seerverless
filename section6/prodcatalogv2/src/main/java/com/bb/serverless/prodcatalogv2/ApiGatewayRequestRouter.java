package com.bb.serverless.prodcatalogv2;

import com.bb.serverless.prodcatalogv2.exception.BadRequestException;
import com.bb.serverless.prodcatalogv2.exception.RecordNotFoundException;
import com.bb.serverless.prodcatalogv2.exception.UnknownException;
import com.bb.serverless.prodcatalogv2.model.PageRequest;
import com.bb.serverless.prodcatalogv2.processor.ProductCategoryProcessor;
import com.bb.serverless.prodcatalogv2.processor.ProductProcessor;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ApiGatewayRequestRouter {

    private static final Logger log = Logger.getLogger(ApiGatewayRequestRouter.class);

    private static final ProductCategoryProcessor prodCategoryProcessor = new ProductCategoryProcessor();

    private static final ProductProcessor productProcessor = new ProductProcessor();

    private static final Map<Class<? extends  Exception>, Integer> ERROR_CODE_MAP =
            new HashMap<Class<? extends Exception>, Integer>();

    static {
        //we could add an errorCode property in the exception classes
        //but that would mean making them specific to HTTP protocol.
        //an alternative is to create an abstraction around the error code
        ERROR_CODE_MAP.put(BadRequestException.class, 400);
        ERROR_CODE_MAP.put(RecordNotFoundException.class, 404);
        ERROR_CODE_MAP.put(UnknownException.class, 500);
    }

    public ApiGatewayResponse routeRequest(Map<String, Object> request) {

        String resource = (String) request.get("resource");
        String httpMethod = (String) request.get("httpMethod");

        Map<String, Object> pathParams = (Map<String, Object>) request.get("pathParameters");
        Map<String, Object> queryStringParams = (Map<String, Object>) request.get("queryStringParameters");

        Object body = null;

        try {
            //Ideally something like a command pattern would be a good choice for Production code
            // - the below if-else based approach is only to illustrate how to look up the request
            //and figure out the intended operation.
            if (StringUtils.equals(httpMethod, "GET")) {
                if (StringUtils.equals(resource, "/")) {
                    body = prodCategoryProcessor.getAllProductCategories();
                }
                if (StringUtils.equals(resource, "/{product_category_id}")) {
                    Integer productCategoryId = extractProductCategoryId(pathParams);
                    PageRequest pageRequest = extractPageRequest(queryStringParams);
                    body =  productProcessor.getByProductCategoryId(productCategoryId, pageRequest);
                }
            }
        } catch (Exception e) {
            return prepareResponse(e); //return error code corresponding to the exception
        }
        if (body == null) {
            return prepareResponse(new Exception()); //return 500
        }
        return prepareResponse(body); //return 200
    }

    private ApiGatewayResponse prepareResponse(Integer errorCode, Object body) {
        return new ApiGatewayResponse(errorCode, body, null);
    }

    private ApiGatewayResponse prepareResponse(Object body) {
        return prepareResponse(200, body);
    }

    private PageRequest extractPageRequest(Map<String, Object> queryStringParams) throws Exception {
        PageRequest pageRequest = null;
        try {
            pageRequest = new PageRequest();
            pageRequest.setPageSize(Integer.valueOf((String) queryStringParams.get("page_size")));
            pageRequest.setPage(Integer.valueOf((String) queryStringParams.get("page")));
        } catch (Exception e) {
            throw new BadRequestException("Query parameters should contain page_size and page");
        }

        return pageRequest;
    }

    private Integer extractProductCategoryId(Map<String, Object> pathParams) throws Exception {
        try {
            log.info("Pathparams:" + pathParams);
            log.info("product_category_id:" + pathParams.get("product_category_id"));
            return Integer.valueOf((String) pathParams.get("product_category_id"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BadRequestException("Request path should contain a numeric product category id");
        }
    }

    private ApiGatewayResponse prepareResponse(Exception e) {
        Class<? extends Exception> clazz = e.getClass();
        Integer errorCode = 500;
        String body = "Unknown Server Error";

        if (ERROR_CODE_MAP.containsKey(clazz)) {
            errorCode = ERROR_CODE_MAP.get(clazz);
            body = e.getMessage();
        }
        return prepareResponse(errorCode, body);

    }
}
