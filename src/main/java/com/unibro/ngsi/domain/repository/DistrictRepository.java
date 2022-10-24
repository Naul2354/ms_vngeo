package com.unibro.ngsi.domain.repository;

import com.unibro.ngsi.domain.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, String>, JpaSpecificationExecutor<District> {

    @Transactional(readOnly = true)
    @Query("SELECT o FROM District o WHERE o.maqh = :maqh")
    Optional<District> findObjectByCode(@Param("maqh") String maqh);

    @Transactional(readOnly = true)
    @Query("SELECT o FROM District o WHERE matp = :matp")
    List<District> findAllObject(String matp);

}

