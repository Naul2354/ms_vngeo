/*
 * To change this license header, choose License Headers in Province Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto.province;

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
public class ProvinceRequestDto {

    private String matp;

    private String name;

    private String type;

    private String slug;

    // private LinkedHashMap<String, Object> extraAttribute;
}
