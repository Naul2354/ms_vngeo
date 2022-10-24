package com.unibro.ngsi.domain.service;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.District;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DistrictService {

    District getObject(String code);

    List<District> getAllObject(String provinceCode);

    Page<District> searchObject(String provinceCode, int page, int pageSize, FilterPostRequestDto filter);

}
