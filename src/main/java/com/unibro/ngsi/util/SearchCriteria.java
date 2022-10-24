/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.util;

import lombok.*;

import java.io.Serializable;

/**
 * @author ThoND
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SearchCriteria implements Serializable {
    private String key;
    private SearchOperation operation;
    private String operator;
    private Object value;
}
