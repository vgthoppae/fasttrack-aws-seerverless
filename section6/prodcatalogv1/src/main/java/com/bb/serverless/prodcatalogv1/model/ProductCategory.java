package com.bb.serverless.prodcatalogv1.model;

public enum ProductCategory {

    BOOKS(1),
    MEN_SHOES(2),
    WOMEN_SHOES(3),
    ELECTRONICS(4),
    PHONES(5);

    private int code;

    private ProductCategory(int code) {
        this.code = code;
    }

    public int code() {return this.code;};
}
