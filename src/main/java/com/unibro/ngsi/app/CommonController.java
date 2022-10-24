/*
 * To change this license header, choose License Headers in ObjectType Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.app;

import com.unibro.ngsi.domain.dto.district.DistrictDto;
import com.unibro.ngsi.domain.dto.province.ProvinceDto;
import com.unibro.ngsi.domain.dto.ward.WardDto;
import com.unibro.ngsi.domain.service.CommonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nguyenductho
 */
@Slf4j
@RestController
public class CommonController {

    @Autowired
    CommonService commonService;

    @GetMapping("/api/common/province/getall")
    public ResponseEntity<List<ProvinceDto>> getProvinces() {
        List<ProvinceDto> response = commonService.getAllProvince();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/common/province/getByCode/{provinceCode}")
    public ResponseEntity<ProvinceDto> getProvince(
            @PathVariable(value = "provinceCode", required = true) String provinceCode) {
        ProvinceDto response = commonService.getProvince(provinceCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/common/district/getall/{provinceCode}")
    public ResponseEntity<List<DistrictDto>> getDistricts(
            @PathVariable(value = "provinceCode", required = true) String provinceCode) {
        List<DistrictDto> response = commonService.getAllDistrict(provinceCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/common/district/getByCode/{districtCode}")
    public ResponseEntity<DistrictDto> getDistrict(
            @PathVariable(value = "districtCode", required = true) String districtCode) {
        DistrictDto response = commonService.getDistrict(districtCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/common/ward/getall/{districtCode}")
    public ResponseEntity<List<WardDto>> getWards(
            @PathVariable(value = "districtCode", required = true) String districtCode) {
        List<WardDto> response = commonService.getAllWard(districtCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/api/common/ward/getByCode/{wardCode}")
    public ResponseEntity<WardDto> getWard(
            @PathVariable(value = "wardCode", required = true) String wardCode) {
        WardDto response = commonService.getWard(wardCode);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
