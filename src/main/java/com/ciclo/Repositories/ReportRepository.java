package com.ciclo.Repositories;

import com.ciclo.Entities.Report;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long> {
    @Query(value = "SELECT r FROM Report r")
    List<Report> getAllReports();

    @Query(value = "SELECT * FROM Report INNER JOIN Ciclovia ON Ciclovia.id_Ciclovia = Report.id_Ciclovia WHERE Ciclovia.id_Ciclovia = ?1", nativeQuery = true)
	List<Report> getReportsById(Long idCiclovia);

    @Query(value = "SELECT * FROM Report WHERE id_User = ?1", nativeQuery = true)
    Report getReportByIdUser(Long idUser);
}
