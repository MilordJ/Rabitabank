/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.domain;

import lombok.Data;

/**
 *
 * @author Nazrin
 */

@Data
public class MultilanguageString {
    private String az;
    private String en;
    private String ru;

    public MultilanguageString() {
    }

    public MultilanguageString(String az, String en, String ru) {
        this.az = az;
        this.en = en;
        this.ru = ru;
    }

    

   
}
