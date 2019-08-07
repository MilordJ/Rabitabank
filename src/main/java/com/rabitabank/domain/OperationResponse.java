/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rabitabank.domain;

import com.rabitabank.domain.MultilanguageString;
import lombok.Data;

/**
 *
 * @author Nazrin
 */

@Data
public class OperationResponse {
    
    public enum ResultCode {
    OK,
    ERROR,
    UNAUTHORIZED,
    INVALID_PARAMS,
    DUPLICATE_DATA
}
    
    private ResultCode code;
    private MultilanguageString message;
    private Object data;

    public OperationResponse(ResultCode code) {
        this.code = code;
    }

    public OperationResponse(ResultCode code, Object data) {
        this.code = code;
        this.data = data;
    }

    public OperationResponse(ResultCode code, MultilanguageString message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
