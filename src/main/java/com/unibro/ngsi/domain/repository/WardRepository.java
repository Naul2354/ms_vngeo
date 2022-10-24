package com.unibro.ngsi.domain.repository;

import com.unibro.ngsi.domain.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, String>, JpaSpecificationExecutor<Ward> {


    @Transactional(readOnly = true)
    @Query("SELECT o FROM Ward o WHERE o.xaid = :xaid")
    Optional<Ward> findObjectByCode(@Param("xaid") String xaid);

    @Transactional(readOnly = true)
    @Query("SELECT o FROM Ward o WHERE maqh = :maqh")
    List<Ward> findAllObject(String maqh);

}

