package com.bb.serverless.prodcatalogservice.processor;

import com.bb.serverless.prodcatalogservice.dao.DummyProductDAO;
import com.bb.serverless.prodcatalogservice.dao.MapBasedProdCategoryDAO;
import com.bb.serverless.prodcatalogservice.dao.ProdCategoryDAO;
import com.bb.serverless.prodcatalogservice.dao.ProductDAO;
import com.bb.serverless.prodcatalogservice.model.*;

import java.util.Set;

public class ProductCategoryProcessor {

    private static final ProdCategoryDAO prodCategoryDAO = new MapBasedProdCategoryDAO();

    private static final ProductDAO productDAO = new DummyProductDAO();

    public ProdCatalogResponse<Integer, ProductCategory> getAllProductCategories(ProdCatalogRequest request) {
        Set<ProductCategory> modelSet = prodCategoryDAO.getAllProductCategories();

        ProdCatalogResponse<Integer, ProductCategory> response = new ProdCatalogResponse<Integer, ProductCategory>();

        PageableModel<ProductCategory> pageableModel = new PageableModel<ProductCategory>(1, request.getPageRequest(), modelSet);
        response.setPageableModel(pageableModel);

        return response;
    }

    public ProdCatalogResponse<Integer, Product> getProductsByProdCategoryId(ProdCatalogRequest request) throws Exception{
        PageableModel<Product> pageableModel = productDAO.getByProductCategoryId(request.getProdCategoryId(), request.getPageRequest());

        ProdCatalogResponse<Integer, Product> response = new ProdCatalogResponse<Integer, Product>();
        response.setRequest(request.getProdCategoryId());
        response.setPageableModel(pageableModel);

        return response;
    }
    
}
