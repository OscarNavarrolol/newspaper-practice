package com.newspaper.repository;

import com.newspaper.entity.New;
import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<New,Long> {

    @Query(nativeQuery = true, value = "select * from news where max(publication_date)")
    User findRecentNew();

}
