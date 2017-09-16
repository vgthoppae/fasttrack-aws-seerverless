package com.bb.serverless.prodcatalogservice;

import com.bb.serverless.prodcatalogservice.exception.BadRequestException;
import com.bb.serverless.prodcatalogservice.model.*;
import com.bb.serverless.prodcatalogservice.processor.ProductCategoryProcessor;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.util.Set;

public class ProdCatalogServiceController {

    private static final Logger log = Logger.getLogger(ProdCatalogServiceController.class);

    private ProductCategoryProcessor productCategoryProcessor = new ProductCategoryProcessor();

    public ProdCatalogResponse process(ProdCatalogRequest request) throws Exception {

        RequestCommand command = request.getRequestCommand();

        if (command == null) {
            log.error("Command is missing in the request");
            throw new BadRequestException("Command is missing in the request");
        }

        switch (command) {
            case GET_PROD_CATEGORIES:
                return productCategoryProcessor.getAllProductCategories(request);
            case GET_PROD_BY_CATEGORY_ID:
                return productCategoryProcessor.getProductsByProdCategoryId(request);
            default:
                break;
        }

        log.error("Unknown Command:"+ command);
        throw new BadRequestException("Unknown Command:"+ command);
    }
}
