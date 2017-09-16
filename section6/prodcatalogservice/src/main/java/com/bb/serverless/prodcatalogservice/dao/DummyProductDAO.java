package com.bb.serverless.prodcatalogservice.dao;

import com.bb.serverless.prodcatalogservice.ProdCatalogServiceLambdaHandler;
import com.bb.serverless.prodcatalogservice.exception.BadRequestException;
import com.bb.serverless.prodcatalogservice.exception.RecordNotFoundException;
import com.bb.serverless.prodcatalogservice.model.PageRequest;
import com.bb.serverless.prodcatalogservice.model.PageableModel;
import com.bb.serverless.prodcatalogservice.model.Product;
import org.apache.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by vgthoppae on 6/15/17.
 */
public class DummyProductDAO implements ProductDAO {

    private static final Logger log = Logger.getLogger(DummyProductDAO.class);

    public PageableModel<Product> getByProductCategoryId(Integer prodCategoryId, PageRequest pageRequest) throws Exception{

        //Dummy implementation

        if (prodCategoryId != null && prodCategoryId.equals(1)) {
            Product product = new Product();
            product.setId(100);
            product.setName("An awesome Product");
            product.setPrice(12f);
            product.setSpec("A Product that solves every human crisis");

            Collection<Product> products = new HashSet<Product>();
            products.add(product);

            PageableModel<Product> pageableModel = new PageableModel<Product>(26, pageRequest, products);

            return pageableModel;
        }
        log.error("Product Category is either missing or not supported");
        throw new RecordNotFoundException("Prodct Category Id not found");
    }
}
