package com.ciclo.Repositories;

import com.ciclo.Entities.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "SELECT r FROM Report r")
    List<Report> getAllReports();
}
