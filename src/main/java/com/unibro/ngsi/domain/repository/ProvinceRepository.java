package com.unibro.ngsi.domain.repository;

import com.unibro.ngsi.domain.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, String>, JpaSpecificationExecutor<Province> {

    @Transactional(readOnly = true)
    @Query("SELECT o FROM Province o WHERE o.matp = :matp")
    Optional<Province> findObjectByCode(@Param("matp") String matp);

    @Transactional(readOnly = true)
    @Query("SELECT o FROM Province o")
    List<Province> findAllObject();

}

