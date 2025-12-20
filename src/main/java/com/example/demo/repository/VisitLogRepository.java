package com.example.demo.repository;

import com.example.demo.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitLogRepository extends JpaRepository<VisitLog, Long> {
    
    // Required for listing logs per visitor
    List<VisitLog> findByVisitorId(Long visitorId);

    // Required by spec: findByVisitorSince
    @Query("SELECT v FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime >= :since")
    List<VisitLog> findByVisitorSince(@Param("visitorId") Long visitorId, @Param("since") LocalDateTime since);

    // Required by spec: countVisitsInWindow
    @Query("SELECT COUNT(v) FROM VisitLog v WHERE v.visitor.id = :visitorId AND v.entryTime BETWEEN :start AND :end")
    long countVisitsInWindow(@Param("visitorId") Long visitorId, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}