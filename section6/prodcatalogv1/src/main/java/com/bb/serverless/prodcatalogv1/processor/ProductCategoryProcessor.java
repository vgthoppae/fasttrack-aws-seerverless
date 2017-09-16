package com.bb.serverless.prodcatalogv1.processor;

import com.bb.serverless.prodcatalogv1.dao.MapBasedProdCategoryDAO;
import com.bb.serverless.prodcatalogv1.dao.ProdCategoryDAO;

/**
 * Created by vgthoppae on 6/10/17.
 */
public class ProductCategoryProcessor {

    private static final ProdCategoryDAO prodCategoryDAO = new MapBasedProdCategoryDAO();

    public Object getAllProductCategories() {
        return prodCategoryDAO.getAllProductCategories();
    }
}
