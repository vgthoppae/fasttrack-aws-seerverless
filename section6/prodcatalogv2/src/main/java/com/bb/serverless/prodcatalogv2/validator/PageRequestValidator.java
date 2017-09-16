package com.bb.serverless.prodcatalogv2.validator;

import com.bb.serverless.prodcatalogv2.exception.BadRequestException;
import com.bb.serverless.prodcatalogv2.model.PageRequest;

/**
 * Created by vgthoppae on 6/16/17.
 */
public class PageRequestValidator {

    private static final String BAD_REQ_MSG = "Missing or bad pagination parameters - both page and page size are needed";

    public void validate(PageRequest pageRequest) throws Exception {
        Integer page = null, pageSize = null;
        if (pageRequest != null) {
            page = pageRequest.getPage();
            pageSize = pageRequest.getPageSize();
        }

        if (page == null || pageSize == null || page <0 || pageSize <=0) {
            throw new BadRequestException(BAD_REQ_MSG);
        }
    }
}
