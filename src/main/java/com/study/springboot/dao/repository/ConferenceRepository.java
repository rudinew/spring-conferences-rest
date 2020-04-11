package com.study.springboot.dao.repository;

import com.study.springboot.dao.entity.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    long countByNameAndIdNot(String name, Long id);

    @Query("select count(u) from Conference u where u.dtEnd >= :dtStart and u.dtStart <= :dtEnd")
    long countByDtEndAfterAndDtStartBefore(@Param("dtStart") Date dtStart, @Param("dtEnd") Date dtEnd);
}
