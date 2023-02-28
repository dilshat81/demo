package com.example.demo.controllers.feigns;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import feign.Response.Body;
import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignErrorDecoder implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {


        switch (response.status()){
            case 401:
                /*
                 * "schemas" : ""
                 * "details" : ""
                 * "status" : ""
                 */
                Body agardeoInvalidResponse= response.body();
                System.err.println("Status code " + response.status() + ", methodKey = " + methodKey);
                return new ResponseStatusException(HttpStatus.valueOf(
                        response.status()), agardeoInvalidResponse.toString());
            case 403:
                System.err.println("Status code " + response.status() + ", methodKey = " + methodKey);
            /*case 404:
            {
                     logger.error("Error took place when using Feign client to send HTTP Request. Status code " + response.status() + ", methodKey = " + methodKey);
                    return new ResponseStatusException(HttpStatus.valueOf(response.status()), "<You can add error message description here>");
            }*/
            default:
                return new Exception(response.reason());
        }
    }

}