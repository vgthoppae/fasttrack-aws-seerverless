package com.bb.serverless.prodcatalogv1.dao;

import com.bb.serverless.prodcatalogv1.model.ProductCategory;

import java.util.*;

/**
 * Created by vgthoppae on 6/10/17.
 */
public class MapBasedProdCategoryDAO implements ProdCategoryDAO {

    private static final Map<Integer, String> PRODUCT_CATEGORIES= new HashMap<Integer, String>();

    static {
        PRODUCT_CATEGORIES.put(ProductCategory.BOOKS.code(), ProductCategory.BOOKS.name());
        PRODUCT_CATEGORIES.put(ProductCategory.MEN_SHOES.code(), ProductCategory.MEN_SHOES.name());
        PRODUCT_CATEGORIES.put(ProductCategory.WOMEN_SHOES.code(), ProductCategory.WOMEN_SHOES.name());
        PRODUCT_CATEGORIES.put(ProductCategory.ELECTRONICS.code(), ProductCategory.ELECTRONICS.name());
        PRODUCT_CATEGORIES.put(ProductCategory.PHONES.code(), ProductCategory.PHONES.name());
    }

    public Map<Integer, String> getAllProductCategories() {
        return PRODUCT_CATEGORIES;
    }
}
