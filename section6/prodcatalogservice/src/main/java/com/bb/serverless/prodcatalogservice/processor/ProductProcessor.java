package com.bb.serverless.prodcatalogservice.processor;

import com.bb.serverless.prodcatalogservice.dao.DummyProductDAO;
import com.bb.serverless.prodcatalogservice.dao.ProductDAO;
import com.bb.serverless.prodcatalogservice.model.PageRequest;
import com.bb.serverless.prodcatalogservice.model.PageableModel;
import com.bb.serverless.prodcatalogservice.model.Product;
import com.bb.serverless.prodcatalogservice.validator.PageRequestValidator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vgthoppae on 6/10/17.
 */
public class ProductProcessor {

    private static final ProductDAO productDAO = new DummyProductDAO();

    private PageRequestValidator pageRequestValidator = new PageRequestValidator();

    public Map<String, Object> getByProductCategoryId(Integer productCategoryId, PageRequest pageRequest) throws Exception {

        pageRequestValidator.validate(pageRequest);

        PageableModel<Product> pageableModel = productDAO.getByProductCategoryId(productCategoryId, pageRequest);

        Map<String, Object> results = new HashMap<String, Object>();
        results.put("product_category_id", productCategoryId);
        results.put("total_pages", pageableModel.getTotalPages());
        results.put("page", pageableModel.getPageRequest().getPage());
        results.put("page_size", pageableModel.getPageRequest().getPageSize());
        results.put("product", pageableModel.getModel());

        return results;
    }


    
}
