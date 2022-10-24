package com.unibro.ngsi.domain.service;

import com.unibro.ngsi.domain.dto.district.DistrictDto;;
import com.unibro.ngsi.domain.dto.province.ProvinceDto;
import com.unibro.ngsi.domain.dto.ward.WardDto;

import java.util.List;


public interface CommonService {

    List<ProvinceDto> getAllProvince();

    ProvinceDto getProvince(String provinceCode);

    DistrictDto getDistrict(String districtCode);

    WardDto getWard(String wardCode);

    List<DistrictDto> getAllDistrict(String provinceCode);

    List<WardDto> getAllWard(String wardCode);

}
