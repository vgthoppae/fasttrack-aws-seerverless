package com.bb.serverless.prodcatalogservice.dao;

import com.bb.serverless.prodcatalogservice.model.ProductCategory;

import java.util.Map;
import java.util.Set;

public interface ProdCategoryDAO {

    Set<ProductCategory> getAllProductCategories();

}
