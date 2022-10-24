package com.unibro.ngsi.domain.service.impl;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.Province;
import com.unibro.ngsi.domain.repository.ProvinceRepository;
import com.unibro.ngsi.domain.service.ProvinceService;
import com.unibro.ngsi.domain.specification.ProvinceSpecificationBuilder;
import com.unibro.ngsi.util.SearchCriteria;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProvinceServiceImpl implements ProvinceService {


    @Autowired
    private ProvinceRepository provinceRepository;


    @Override
    @Cacheable(cacheNames = {"province"}, key = "#matp")
    public Province getObject(String matp) {
        Optional<Province> opt = provinceRepository.findObjectByCode(matp);
        if (!opt.isPresent()) {
            return null;
        }
        Province object = opt.get();
        return object;
    }

    @Override
    public List<Province> getAllObject() {
        List<Province> objects = provinceRepository.findAllObject();
        return objects;
    }

    @Override
    public Page<Province> searchObject(int page, int pageSize, FilterPostRequestDto dto) {
        List<SearchCriteria> searchCriteria = dto.getFilters();
        ProvinceSpecificationBuilder builder = new ProvinceSpecificationBuilder(searchCriteria);
        Specification<Province> spec = builder.build();

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(dto.getOrderList()));
        Page<Province> pageObjects = provinceRepository.findAll(spec, pageRequest);
        return pageObjects;
    }

}

