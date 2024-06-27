package com.newspaper.repository;

import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM users u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);

}
