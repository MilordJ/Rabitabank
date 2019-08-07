/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.dao;

import com.rabitabank.domain.OperationResponse;

/**
 *
 * @author Lito
 */
public interface IWrapperDAO {
    OperationResponse Add(int a, int b);
    OperationResponse Divide(int a, int b);
    OperationResponse Multiple(int a, int b);
    OperationResponse Subtract(int a, int b);
}
