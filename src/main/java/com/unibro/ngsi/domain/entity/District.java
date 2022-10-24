package com.unibro.ngsi.domain.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "district")
@TypeDefs({
        @TypeDef(name = "json", typeClass = JsonStringType.class),
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maqh")
public class District implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5912819255803631338L;

    @Id
    @Column(nullable = true, name = "maqh", length = 5)
    private String maqh;

    @NotBlank(message = "Name must not be empty")
    @Column(nullable = false, name = "name", length = 100)
    private String name;

    @NotBlank(message = "Type must not be empty")
    @Column(nullable = false, name = "type", length = 30)
    private String type;

    @NotBlank(message = "Matp must not be empty")
    @Column(nullable = false, name = "matp", length = 5)
    private String matp;

}
