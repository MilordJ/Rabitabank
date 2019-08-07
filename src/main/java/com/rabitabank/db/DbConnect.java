/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nazrin
 */
@Repository
public class DbConnect {
    
    @Autowired
    private DataSource dataSource;
    
    public Connection getConnection() throws SQLException {
        Locale.setDefault(Locale.US);
        return dataSource.getConnection();
    }
}
