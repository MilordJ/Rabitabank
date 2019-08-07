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
public interface ILoggerDAO {
    void logRequest(String value);
    void logResponse(int requestId, String value);
}
