package com.eventRegistration.users.repository;


import com.eventRegistration.entity.ErUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<ErUsers, Long> {

    Optional<ErUsers> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
}
