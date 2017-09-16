package com.bb.serverless.prodcatalogservice.model;

import java.util.Collection;


public class PageableModel<T> {

    private final Integer totalPages;

    private final PageRequest pageRequest;

    private final Collection<T> model;

    public PageableModel(Integer totalPages, PageRequest pageRequest, Collection<T> model) {
        this.totalPages = totalPages;
        this.pageRequest = pageRequest;
        this.model = model;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public PageRequest getPageRequest() {
        return pageRequest;
    }

    public Collection<T> getModel() {
        return model;
    }
}
