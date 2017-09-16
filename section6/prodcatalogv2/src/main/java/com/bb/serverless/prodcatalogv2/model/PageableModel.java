package com.bb.serverless.prodcatalogv2.model;

import java.util.Collection;

/**
 * Created by vgthoppae on 6/16/17.
 */
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
