package com.unibro.ngsi.domain.service;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.Ward;
import org.springframework.data.domain.Page;

import java.util.List;

public interface WardService {

    Ward getObject(String code);

    List<Ward> getAllObject(String districtCode);

    Page<Ward> searchObject(String districtCode, int page, int pageSize, FilterPostRequestDto filter);

}
