package com.bb.serverless.prodcatalogservice.dao;

import com.bb.serverless.prodcatalogservice.model.ProductCategory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vgthoppae on 6/10/17.
 */
public class MapBasedProdCategoryDAO implements ProdCategoryDAO {

    private static final Set<ProductCategory> PRODUCT_CATEGORIES= new HashSet<ProductCategory>();

    static {
        PRODUCT_CATEGORIES.add(new ProductCategory(1, "BOOKS"));
        PRODUCT_CATEGORIES.add(new ProductCategory(2, "MEN_SHOES"));
        PRODUCT_CATEGORIES.add(new ProductCategory(3, "WOMEN_SHOES"));
        PRODUCT_CATEGORIES.add(new ProductCategory(4, "ELECTRONICS"));
        PRODUCT_CATEGORIES.add(new ProductCategory(5, "PHONES"));
    }

    public Set<ProductCategory> getAllProductCategories() {
        return PRODUCT_CATEGORIES;
    }
}
