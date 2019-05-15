package com.eventRegistration.events.repository;

import com.eventRegistration.entity.ErSlEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<ErSlEvents, Long> {

    Optional<ErSlEvents> findByName(String name);

    Optional<ErSlEvents> findByStartDateAndEndDate(Date startDate, Date endDate);
}
