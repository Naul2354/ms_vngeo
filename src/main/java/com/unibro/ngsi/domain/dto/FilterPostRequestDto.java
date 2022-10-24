/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unibro.ngsi.util.OrderCriteria;
import com.unibro.ngsi.util.SearchCriteria;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterPostRequestDto {

    List<SearchCriteria> filters;

    List<OrderCriteria> orders;

    @JsonIgnore
    public Order[] getOrderList() {
        if (orders == null || orders.isEmpty()) {
            return null;
        }
        Order[] ret = new Order[orders.size()];
        for (int i = 0; i < orders.size(); i++) {
            OrderCriteria o = orders.get(i);
            if (o.isAsc()) {
                ret[i] = new Order(Direction.ASC, o.getKey());
            } else {
                ret[i] = new Order(Direction.DESC, o.getKey());
            }
        }
        return ret;
    }
}
