/*
 * To change this license header, choose License Headers in Ward Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto.ward;

import lombok.*;

/**
 * @author Thond
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class WardDto {

    private String xaid;

    private String name;

    private String type;

    private String maqh;

    // private LinkedHashMap<String, Object> extraAttribute;
}
