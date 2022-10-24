package com.unibro.ngsi.domain.service.impl;

import com.unibro.ngsi.domain.dto.FilterPostRequestDto;
import com.unibro.ngsi.domain.entity.District;
import com.unibro.ngsi.domain.repository.DistrictRepository;
import com.unibro.ngsi.domain.service.DistrictService;
import com.unibro.ngsi.domain.specification.DistrictSpecificationBuilder;
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
public class DistrictServiceImpl implements DistrictService {


    @Autowired
    private DistrictRepository districtRepository;



    @Override
    @Cacheable(cacheNames = {"district"}, key = "#maqh")
    public District getObject(String maqh) {
        Optional<District> opt = districtRepository.findObjectByCode(maqh);
        if (!opt.isPresent()) {
            return null;
        }
        District object = opt.get();
        return object;
    }

    @Override
    public List<District> getAllObject(String provinceCode) {
        List<District> objects = districtRepository.findAllObject(provinceCode);
        return objects;
    }


    @Override
    public Page<District> searchObject(String provinceCode, int page, int pageSize, FilterPostRequestDto dto) {
        List<SearchCriteria> searchCriteria = dto.getFilters();
        searchCriteria.add(Utils.getEqualCriteria("matp", provinceCode));
        DistrictSpecificationBuilder builder = new DistrictSpecificationBuilder(searchCriteria);
        Specification<District> spec = builder.build();

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize, Sort.by(dto.getOrderList()));
        Page<District> pageObjects = districtRepository.findAll(spec, pageRequest);
        return pageObjects;
    }
}

