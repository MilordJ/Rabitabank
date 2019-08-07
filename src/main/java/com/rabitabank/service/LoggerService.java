/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.service;

import com.rabitabank.dao.LoggerDAO;
import com.rabitabank.domain.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Lito
 */
public class LoggerService implements ILoggerService{

    @Autowired
    LoggerDAO loggerDAO;
    
    @Override
    public void logRequest(String value) {
         loggerDAO.logRequest(value);
    }

    
}
