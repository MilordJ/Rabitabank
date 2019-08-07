/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.dao;

import com.rabitabank.db.DbConnect;
import com.rabitabank.domain.OperationResponse;
import com.rabitabank.domain.OperationResponse.ResultCode;
import org.apache.log4j.Logger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Lito
 */
@Repository
public class LoggerDAO implements ILoggerDAO{
    private static final Logger log = Logger.getLogger(LoggerDAO.class);
//    
    @Autowired
    private DbConnect dbConnect;

    @Override
    public void logRequest(String value) {
        OperationResponse operationResponse = new OperationResponse(OperationResponse.ResultCode.ERROR);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        try (Connection connection = dbConnect.getConnection()) {
            try (CallableStatement cl = connection.prepareCall("{call = --(?,?)}")) {
                cl.setString(1, dateFormat.format(cal.getTime()));
                cl.registerOutParameter(2, Types.INTEGER);
                cl.execute();
                
                operationResponse.setCode(ResultCode.OK);
                
                this.logResponse(cl.getInt(2), value);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


    @Override
    public void logResponse(int requestId, String value) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        try (Connection connection = dbConnect.getConnection()) {
            try (CallableStatement cl = connection.prepareCall("{call = --(?,?,?)}")) {
                cl.setString(1, dateFormat.format(cal.getTime()));
                cl.setInt(2, requestId);
                cl.setString(3, value);
                cl.execute();
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }
}
