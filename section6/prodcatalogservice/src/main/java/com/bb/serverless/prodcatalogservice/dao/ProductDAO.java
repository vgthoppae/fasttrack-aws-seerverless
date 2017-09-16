package com.bb.serverless.prodcatalogservice.dao;

import com.bb.serverless.prodcatalogservice.model.PageRequest;
import com.bb.serverless.prodcatalogservice.model.PageableModel;
import com.bb.serverless.prodcatalogservice.model.Product;


public interface ProductDAO {

    PageableModel<Product> getByProductCategoryId(Integer prodCategoryId, PageRequest pageRequest) throws Exception;

}
