/*
 * To change this license header, choose License Headers in Province Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto.province;

import lombok.*;

import java.util.List;

/**
 * @author LenovoUser
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProvinceArrayDto {

    List<ProvinceDto> result;
    long size;
    int page;
    int pageSize;
}

