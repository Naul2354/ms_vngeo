package com.unibro.ngsi.domain.service.impl;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.Ward;
import com.unibro.ngsi.domain.repository.WardRepository;
import com.unibro.ngsi.domain.service.WardService;
import com.unibro.ngsi.domain.specification.WardSpecificationBuilder;
import com.unibro.ngsi.util.SearchCriteria;
import com.unibro.ngsi.util.Utils;
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
public class WardServiceImpl implements WardService {


    @Autowired
    private WardRepository wardRepository;


    @Override
    @Cacheable(cacheNames = {"ward"}, key = "#xaid")
    public Ward getObject(String xaid) {
        Optional<Ward> opt = wardRepository.findObjectByCode(xaid);
        if (!opt.isPresent()) {
            return null;
        }
        Ward object = opt.get();
        return object;
    }


    @Override
    public List<Ward> getAllObject(String districtCode) {
        List<Ward> objects = wardRepository.findAllObject(districtCode);
        return objects;
    }


    @Override
    public Page<Ward> searchObject(String districtCode, int page, int pageSize, FilterPostRequestDto dto) {
        List<SearchCriteria> searchCriteria = dto.getFilters();
        searchCriteria.add(Utils.getEqualCriteria("maqh", districtCode));
        WardSpecificationBuilder builder = new WardSpecificationBuilder(searchCriteria);
        Specification<Ward> spec = builder.build();

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(dto.getOrderList()));
        Page<Ward> pageObjects = wardRepository.findAll(spec, pageRequest);
        return pageObjects;
    }

}

