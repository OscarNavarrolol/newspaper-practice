package com.newspaper.repository;

import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

//    User findByUsernameAndPassword(String username, String password);

    @Query("SELECT u FROM User u WHERE u.userName = :username AND u.password = :password")
    User findByUsernameAndPassword(String username, String password);


}
