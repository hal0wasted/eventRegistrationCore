package com.eventRegistration.eventRegistration.repository;

import com.eventRegistration.entity.ErEventRegistrations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EventRegistrationRepository extends JpaRepository<ErEventRegistrations, Long> {

//    @Query("Select e from ErEventRegistrations where event.id = :eventId and user.id = :userId")
//    Optional<ErEventRegistrations> findOneByUserIdAndEventId(@Param("eventId") Long eventId,
//                                                             @Param("userId") Long userId);

    Optional<ErEventRegistrations> findOneByUserIdAndEventId(Long userId, Long eventId);

}
