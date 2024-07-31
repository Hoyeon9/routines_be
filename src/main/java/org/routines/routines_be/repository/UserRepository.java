package org.routines.routines_be.repository;

import org.routines.routines_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    User findByEmail(String email);
}
