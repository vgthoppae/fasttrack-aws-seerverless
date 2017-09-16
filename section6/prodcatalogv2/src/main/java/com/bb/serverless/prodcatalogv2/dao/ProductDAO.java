package com.bb.serverless.prodcatalogv2.dao;

import com.bb.serverless.prodcatalogv2.model.PageRequest;
import com.bb.serverless.prodcatalogv2.model.PageableModel;
import com.bb.serverless.prodcatalogv2.model.Product;


public interface ProductDAO {

    PageableModel<Product> getByProductCategoryId(Integer prodCategoryId, PageRequest pageRequest);

}
