/*
 * To change this license header, choose License Headers in District Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto.district;

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
public class DistrictDto {

    private String maqh;

    private String name;

    private String type;

    private String matp;

    // private LinkedHashMap<String, Object> extraAttribute;
}
