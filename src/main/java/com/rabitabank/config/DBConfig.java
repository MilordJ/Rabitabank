/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 *
 * @author Lito
 */
@Configuration
public class DBConfig {
   
   @Autowired
   private Environment env;
   
   @Bean
   public DataSource dataSource() {
       DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
           dataSourceBuilder.url(env.getProperty("jdbc.url"));
           dataSourceBuilder.username(env.getProperty("jdbc.username"));
           dataSourceBuilder.password(env.getProperty("jdbc.password"));
           return dataSourceBuilder.build();   
   }
}