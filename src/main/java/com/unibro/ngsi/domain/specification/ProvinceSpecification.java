/*
 * To change this license header, choose License Headers in Province Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unibro.ngsi.domain.specification;

import com.unibro.ngsi.domain.entity.Province;
import com.unibro.ngsi.util.SearchCriteria;
import com.unibro.ngsi.util.Utils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author Nguyen Duc Tho
 */
public class ProvinceSpecification implements Specification<Province> {

    /**
     *
     */
    private static final long serialVersionUID = 631932920983354857L;
    private final SearchCriteria criteria;

    ProvinceSpecification(SearchCriteria param) {
        this.criteria = param;
    }

    @Override
    public Predicate toPredicate(
            Root<Province> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        switch (criteria.getOperation()) {
            case EQUALITY:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.equal(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                Object.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), criteria.getValue())
                        );
                        return predicate;
                    }
                } else {
                    if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {
                        // log.info(criteria.getValue().toString());
                        // String test = "2021-11-10 19:06:00";
                        java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                                .parseDateTimeFromISODate(criteria.getValue());
                        // log.info(compareDate.toString());        
                        return builder.equal(root.<java.util.Date>get(criteria.getKey()), compareDate);
                    } else {
                        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                    }
                }

            case NEGATION:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.notEqual(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                Object.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), criteria.getValue())
                        );
                        return predicate;
                    } else {
                        if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {
                            // log.info(criteria.getValue().toString());
                            // String test = "2021-11-10 19:06:00";
                            java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                                    .parseDateTimeFromISODate(criteria.getValue());
                            // log.info(compareDate.toString());
                            return builder.notEqual(root.<java.util.Date>get(criteria.getKey()), compareDate);
                        } else {
                            return builder.notEqual(root.get(criteria.getKey()), criteria.getValue());
                        }
                    }
                }
            case GREATER_THAN:
                if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {

                    java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                            .parseDateTimeFromISODate(criteria.getValue());
                    return builder.greaterThan(root.get(criteria.getKey()), compareDate);
                } else {
                    return builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString());
                }
            case GREATER:
                if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {
                    java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                            .parseDateTimeFromISODate(criteria.getValue());
                    return builder.greaterThanOrEqualTo(root.get(criteria.getKey()), compareDate);
                } else {
                    return builder.greaterThanOrEqualTo(root.get(criteria.getKey()),
                            criteria.getValue().toString());
                }
                // return builder.greaterThanOrEqualTo(root.<String>get(
                // criteria.getKey()), criteria.getValue().toString());
            case LESS:
                if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {
                    java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                            .parseDateTimeFromISODate(criteria.getValue());
                    return builder.lessThanOrEqualTo(root.get(criteria.getKey()),
                            compareDate);
                } else {
                    return builder.lessThanOrEqualTo(root.get(criteria.getKey()),
                            criteria.getValue().toString());
                }
                // return builder.lessThanOrEqualTo(root.<String>get(
                // criteria.getKey()), criteria.getValue().toString());
            case LESS_THAN:
                if (root.get(criteria.getKey()).getJavaType() == java.util.Date.class) {
                    java.util.Date compareDate = com.unibro.ngsi.util.DatetimeHelper
                            .parseDateTimeFromISODate(criteria.getValue());
                    return builder.lessThan(root.get(criteria.getKey()), compareDate);
                } else {
                    return builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString());
                }
            case LIKE:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.like(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), criteria.getValue().toString())
                        );
                        return predicate;
                    }
                }
                return builder.like(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case NOT_LIKE:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.notLike(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))),
                                        criteria.getValue().toString()));
                        return predicate;
                    }
                }
                return builder.notLike(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case STARTS_WITH:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.like(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), criteria.getValue().toString() + "%")
                        );
                        return predicate;
                    }
                }
                return builder.like(root.get(criteria.getKey()), criteria.getValue() + "%");
            case ENDS_WITH:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.like(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), "%" + criteria.getValue().toString())
                        );
                        return predicate;
                    }
                }
                return builder.like(root.get(criteria.getKey()), "%" + criteria.getValue());
            case CONTAINS:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.like(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                                        ), "%" + criteria.getValue().toString() + "%")
                        );
                        return predicate;
                    }
                } else {
                    return builder.like(root.get(
                            criteria.getKey()), "%" + criteria.getValue() + "%");
                }
                // } else {
                //     return builder.equal(root.<String>get(
                //             criteria.getKey()), criteria.getValue());
                // }
            case NOT_CONTAINS:
                if (Utils.checkKeyValueField(criteria.getKey())) {
                    if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                        Predicate predicate = builder.conjunction();
                        List expressions = predicate.getExpressions();
                        expressions.add(
                                builder.notLike(
                                        builder.function(
                                                "JSON_EXTRACT",
                                                String.class,
                                                root.get(Utils.getPrefix(criteria.getKey())),
                                                builder.literal("$." + Utils.getPostfix(criteria.getKey()))),
                                        criteria.getValue().toString()));
                        return predicate;
                    }
                }
                return builder.notLike(root.get(
                        criteria.getKey()), criteria.getValue().toString());
            case IN:
                if (root.get(Utils.getPrefix(criteria.getKey())).getJavaType() == LinkedHashMap.class) {
                    List list = (List) criteria.getValue();
                    Predicate predicate = builder.conjunction();
                    List expressions = predicate.getExpressions();
                    expressions.add(
                            builder.function(
                                    "JSON_EXTRACT",
                                    Object.class,
                                    root.get(Utils.getPrefix(criteria.getKey())),
                                    builder.literal("$." + Utils.getPostfix(criteria.getKey()))
                            ).in(list));
                    return predicate;
                }
                List list = (List) criteria.getValue();
                return root.get(criteria.getKey()).in(list);
            case JSON_CONTAINS:
                Predicate predicate = builder.conjunction();
                List expressions = predicate.getExpressions();
                expressions.add(
                        builder.equal(
                                builder.function(
                                        "JSON_CONTAINS",
                                        Object.class,
                                        root.get(criteria.getKey()),
                                        builder.literal(criteria.getValue()),
                                        builder.literal("$")
                                ), 1
                        )
                );

                return predicate;
            default:
                return null;
        }
    }
}
