package com.unibro.ngsi.domain.service;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.Province;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProvinceService {

    Province getObject(String code);

    List<Province> getAllObject();

    Page<Province> searchObject(int page, int pageSize, FilterPostRequestDto filter);

}
