package com.newspaper.repository;

import com.newspaper.entity.New;
import com.newspaper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewRepository extends JpaRepository<New,Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM news " +
            "WHERE (publication_date, id) IN " +
            "    (SELECT publication_date, MAX(id) AS latest_id " +
            "    FROM news " +
            "    GROUP BY publication_date )" +
            "   ORDER BY publication_date;")
    List<New> findRecentNew();

    @Query(nativeQuery = true, value = "select ne.id, ne.title, ne.content, ne.publication_date, ne.user_id, ca.name_category " +
            "from news as ne , category as ca " +
            "where ne.category_id = ca.id " +
            "and ca.id = :categoryId")
    List<Object[]> getNewsByCategory(Long categoryId);
}
