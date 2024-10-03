package com.newspaper.repository;

import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(nativeQuery = true,value = "SELECT * FROM users u WHERE u.username = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT u.* FROM users u " +
            "JOIN (SELECT user_id, COUNT(*) as count FROM news GROUP BY user_id ORDER BY count DESC LIMIT 5) as ranked_users " +
            "ON u.id = ranked_users.user_id", nativeQuery = true)
    List<User> findTopUsers();
}
