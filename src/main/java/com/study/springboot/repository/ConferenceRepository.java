package com.study.springboot.repository;

import com.study.springboot.domain.Conference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findByNameAndIdNot(String name, Long id);

    @Query("select u from Conference u where u.dtEnd >= :dtStart and u.dtStart <= :dtEnd")
    List<Conference>findByDtEndAfterAndDtStartBefore(@Param("dtStart") Date dtStart, @Param("dtEnd") Date dtEnd);
}
