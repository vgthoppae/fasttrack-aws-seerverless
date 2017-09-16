package com.bb.serverless.prodcatalogservice.model;

public class ProdCatalogResponse<S, T> {

    private S request;

    private PageableModel<T> pageableModel;

    public S getRequest() {
        return request;
    }

    public void setRequest(S request) {
        this.request = request;
    }

    public PageableModel<T> getPageableModel() {
        return pageableModel;
    }

    public void setPageableModel(PageableModel<T> pageableModel) {
        this.pageableModel = pageableModel;
    }
}
