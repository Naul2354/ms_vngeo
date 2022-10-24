package com.unibro.ngsi.domain.dto;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author ThoND
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BaseResponseDto {

    @Builder.Default
    private long size = 0;

    private Object result;
    @Builder.Default

    private int status = 200;

    private String message;

    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Builder.Default
    private Date timestamp = new java.util.Date();

}
