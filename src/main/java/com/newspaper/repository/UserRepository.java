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

    @Query(value = "SELECT u.id, u.username, COUNT(n.id) AS news_count " +
            "FROM users AS u LEFT JOIN " +
            "news n ON u.id = n.user_id " +
            "GROUP BY u.username " +
            "ORDER BY news_count DESC LIMIT 5;", nativeQuery = true)
    List<Object[]> findTopUsers();
}
