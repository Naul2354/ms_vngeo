/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.exception;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDateTime;

/**
 * @author nguyenductho
 */
@Getter
@Setter
public class CustomErrorResponse {

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;
}
