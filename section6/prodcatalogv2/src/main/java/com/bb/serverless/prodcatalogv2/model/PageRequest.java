package com.bb.serverless.prodcatalogv2.model;

/**
 * Created by vgthoppae on 6/16/17.
 */
public class PageRequest {

    private Integer page;

    private Integer pageSize;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
