/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.controller;

import com.rabitabank.domain.OperationResponse;
import com.rabitabank.service.WrapperService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lito
 */

@RestController
@RequestMapping(value = "/wrapper", produces = MediaType.APPLICATION_JSON_VALUE)

public class WrapperController {
    private static final Logger log = Logger.getLogger(WrapperController.class);
        
    @Autowired
    WrapperService wrapperService;
    
    @PostMapping(value = "/add/a/{a:\\d+}/b/{b:\\d+}")
    public OperationResponse Add(@PathVariable int a, @PathVariable int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
     
            log.info("Call Request to JSON");
             operationResponse = wrapperService.Add(a, b);
            log.info("Response from SOAP");
        } catch (Exception e) {
            e.getMessage();
        }
        return operationResponse;
    }
    @PostMapping(value = "/divide/a/{a:\\d+}/b/{b:\\d+}")
    public OperationResponse Divide(@PathVariable int a, @PathVariable int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Call Request to JSON");
            operationResponse = wrapperService.Divide(a, b);            
            log.info("Response from SOAP");
        } catch (Exception e) {
            e.getMessage();
        }
        return operationResponse;
    }
    @PostMapping(value = "/multiple/a/{a:\\d+}/b/{b:\\d+}")
    public OperationResponse Multiple(@PathVariable int a, @PathVariable int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Call Request to JSON");
            operationResponse = wrapperService.Multiple(a, b);
            log.info("Response from SOAP");
        } catch (Exception e) {
            e.getMessage();
        }
        return operationResponse;
    }
    @PostMapping(value = "/subtract/a/{a:\\d+}/b/{b:\\d+}")
    public OperationResponse Subtract(@PathVariable int a, @PathVariable int b) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        try {
            log.info("Call Request to JSON");
            operationResponse = wrapperService.Subtract(a, b);
            log.info("Response from SOAP");
        } catch (Exception e) {
            e.getMessage();
        }
        return operationResponse;
    }
}
