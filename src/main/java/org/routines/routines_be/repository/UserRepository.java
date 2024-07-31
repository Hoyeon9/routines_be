package org.routines.routines_be.repository;

import jakarta.transaction.Transactional;
import org.routines.routines_be.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
    User findByEmail(String email);
    void deleteByUserId(String userId);
    @Modifying
    @Transactional
    @Query(value = "UPDATE User u SET u.password = :password, u.username = :username, u.email = :email WHERE u.userId = :userId")
    int updateByUserId(String userId, String password, String username, String email);
}
