package com.bb.serverless.prodcatalogservice.model;


public class ProdCatalogRequest {

    private RequestCommand requestCommand;

    private Integer prodCategoryId;

    private Product product;

    private PageRequest pageRequest;

    public Integer getProdCategoryId() {
        return prodCategoryId;
    }

    public void setProdCategoryId(Integer prodCategoryId) {
        this.prodCategoryId = prodCategoryId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public void setPageRequest(PageRequest pageRequest) {
        this.pageRequest = pageRequest;
    }

    public RequestCommand getRequestCommand() {
        return requestCommand;
    }

    public void setRequestCommand(RequestCommand requestCommand) {
        this.requestCommand = requestCommand;
    }

    @Override
    public String toString() {
        return "ProdCatalogRequest{" +
                "requestCommand=" + requestCommand +
                ", prodCategoryId=" + prodCategoryId +
                ", product=" + product +
                ", pageRequest=" + pageRequest +
                '}';
    }
}
