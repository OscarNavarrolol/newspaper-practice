package com.newspaper.repository;

import com.newspaper.entity.New;
import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewRepository extends JpaRepository<New,Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM news " +
            "WHERE (publication_date, id) IN " +
            "    (SELECT publication_date, MAX(id) AS latest_id " +
            "    FROM news " +
            "    GROUP BY publication_date )" +
            "   ORDER BY publication_date desc limit 1 ;")
    New findRecentNew();

}
