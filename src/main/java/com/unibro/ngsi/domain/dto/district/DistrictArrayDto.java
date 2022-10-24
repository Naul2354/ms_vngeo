/*
 * To change this license header, choose License Headers in District Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto.district;

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
public class DistrictArrayDto {

    List<DistrictDto> result;
    long size;
    int page;
    int pageSize;
}

