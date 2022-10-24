/*
 * To change this license header, choose License Headers in District Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.specification;

import com.unibro.ngsi.domain.entity.District;
import com.unibro.ngsi.util.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nguyen Duc Tho
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class DistrictSpecificationBuilder {

    private List<SearchCriteria> params;

    public Specification<District> build() {
        if (params.isEmpty()) {
            return null;
        }

        List<Specification<District>> specs = new ArrayList<>();
        params.forEach((param) -> {
            specs.add(new DistrictSpecification(param));
        });

        Specification<District> result = specs.get(0);
        for (int i = 1; i < specs.size(); i++) {
            if (params.get(i).getOperator().equalsIgnoreCase("and")) {
                result = Specification.where(result).and(specs.get(i));
            } else {
                result = Specification.where(result).or(specs.get(i));
            }
        }
        return result;
    }
}

