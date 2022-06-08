package com.jwt.authentication.jwt_authentication.security;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * the Repository using to save and get data from database, the user information will save using it is a simple JPA Repository
 */

@Repository
public interface UserRepository extends JpaRepository<UserApp,Long> {
}
