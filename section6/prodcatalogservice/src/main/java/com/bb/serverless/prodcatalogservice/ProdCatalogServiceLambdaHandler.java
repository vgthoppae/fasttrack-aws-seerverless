package com.bb.serverless.prodcatalogservice;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.bb.serverless.prodcatalogservice.exception.BadRequestException;
import com.bb.serverless.prodcatalogservice.exception.RecordNotFoundException;
import com.bb.serverless.prodcatalogservice.model.ProdCatalogRequest;
import com.bb.serverless.prodcatalogservice.model.ProdCatalogResponse;
import org.apache.log4j.Logger;


public class ProdCatalogServiceLambdaHandler implements RequestHandler<ProdCatalogRequest, ProdCatalogResponse> {

    private static final Logger log = Logger.getLogger(ProdCatalogServiceLambdaHandler.class);

    private static ProdCatalogServiceController controller = new ProdCatalogServiceController();

    public ProdCatalogResponse handleRequest(ProdCatalogRequest request, Context context) {
        log.info("received: " + request);

        try {
            //delegate to controller to process the request
            return controller.process(request);
        } catch (BadRequestException e) {
            log.error(e);
            throw new RuntimeException("BadRequest"); //400
        } catch (RecordNotFoundException e) {
            log.error(e);
            throw new RuntimeException("NotFound"); //404
        } catch (Exception e) {
            log.error(e);
            throw new RuntimeException("Unknown Error"); //500
        }
    }
}

//handler name: com.bb.serverless.prodcatalogservice.ProdCatalogServiceLambdaHandler
