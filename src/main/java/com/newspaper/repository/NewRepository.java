package com.newspaper.repository;

import com.newspaper.entity.New;
import com.newspaper.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewRepository extends JpaRepository<New,Long> {

    @Query(nativeQuery = true, value = "SELECT * " +
            "FROM news " +
            "WHERE (publication_date, id) IN " +
            "    (SELECT publication_date, MAX(id) AS latest_id " +
            "    FROM news " +
            "    GROUP BY publication_date )" +
            "ORDER BY publication_date DESC")
    Page<New> findRecentNew(Pageable pageable);

    @Query(nativeQuery = true,
            countQuery = "SELECT COUNT(*) " +
                    "FROM news AS ne " +
                    "JOIN category ca ON ne.category_id = ca.id " +
                    "WHERE ca.id = :categoryId",
            value = "SELECT ne.* " +
                    "FROM news AS ne " +
                    "JOIN category ca ON ne.category_id = ca.id " +
                    "WHERE ca.id = :categoryId " +
                    "ORDER BY ne.publication_date DESC")
    Page<New> getNewsByCategory(@Param("categoryId") Long categoryId, Pageable pageable);


    @Query(nativeQuery = true, value = "select * from news " +
            "where title = :title")
    Optional<List<New>> findByTitle(String title);

    Page<New> findByUserId(Long userId, Pageable pageable);
}
