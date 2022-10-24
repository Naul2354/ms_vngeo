package com.unibro.ngsi.domain.service.impl;

import com.unibro.ngsi.domain.dto.district.DistrictDto;
import com.unibro.ngsi.domain.dto.province.ProvinceDto;
import com.unibro.ngsi.domain.dto.ward.WardDto;
import com.unibro.ngsi.domain.entity.*;
import com.unibro.ngsi.domain.service.*;
import com.unibro.ngsi.exception.NotfoundException;
import com.unibro.ngsi.util.ObjectMapperUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ProvinceService provinceService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private WardService wardService;

    @Override
    public List<ProvinceDto> getAllProvince() {
        return ObjectMapperUtils.mapAll(this.provinceService.getAllObject(), ProvinceDto.class);
    }

    @Override
    public List<DistrictDto> getAllDistrict(String provinceCode) {
        return ObjectMapperUtils.mapAll(this.districtService.getAllObject(provinceCode), DistrictDto.class);
    }

    @Override
    public List<WardDto> getAllWard(String wardCode) {
        return ObjectMapperUtils.mapAll(this.wardService.getAllObject(wardCode), WardDto.class);
    }

    @Override
    public ProvinceDto getProvince(String provinceCode) {
        Province province = this.provinceService.getObject(provinceCode);
        if (province == null) {
            throw new NotfoundException("Province not found");
        }
        return ObjectMapperUtils.map(province, ProvinceDto.class);
    }

    @Override
    public DistrictDto getDistrict(String districtCode) {
        District district = this.districtService.getObject(districtCode);
        if (district == null) {
            throw new NotfoundException("District not found");
        }
        return ObjectMapperUtils.map(district, DistrictDto.class);
    }

    @Override
    public WardDto getWard(String wardCode) {
        Ward ward = this.wardService.getObject(wardCode);
        if (ward == null) {
            throw new NotfoundException("Ward not found");
        }
        return ObjectMapperUtils.map(ward, WardDto.class);
    }

}
