/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.service;

import com.rabitabank.dao.IWrapperDAO;
import com.rabitabank.dao.WrapperDAO;
import com.rabitabank.domain.OperationResponse;
import com.rabitabank.service.IWrapperService;
import com.rabitabank.service.IWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lito
 */
@Service
public class WrapperService implements IWrapperService{

    @Autowired
    WrapperDAO wrapperDAO;
    
    @Override
    public OperationResponse Add(int a, int b) {
        return wrapperDAO.Add(a, b);
    }

    @Override
    public OperationResponse Divide(int a, int b) {
        return wrapperDAO.Divide(a, b);
    }

    @Override
    public OperationResponse Multiple(int a, int b) {
        return wrapperDAO.Multiple(a, b);
    }

    @Override
    public OperationResponse Subtract(int a, int b) {
        return wrapperDAO.Subtract(a, b);
    }
    
}
