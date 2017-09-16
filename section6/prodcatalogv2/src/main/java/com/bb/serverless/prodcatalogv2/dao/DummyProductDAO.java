package com.bb.serverless.prodcatalogv2.dao;

import com.bb.serverless.prodcatalogv2.model.PageRequest;
import com.bb.serverless.prodcatalogv2.model.PageableModel;
import com.bb.serverless.prodcatalogv2.model.Product;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by vgthoppae on 6/15/17.
 */
public class DummyProductDAO implements ProductDAO {


    public PageableModel<Product> getByProductCategoryId(Integer prodCategoryId, PageRequest pageRequest) {

        //Dummy implementation

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
}
