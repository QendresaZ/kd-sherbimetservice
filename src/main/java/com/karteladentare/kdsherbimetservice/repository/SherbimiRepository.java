package com.karteladentare.kdsherbimetservice.repository;

import com.karteladentare.kdsherbimetservice.domain.Sherbimi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SherbimiRepository extends JpaRepository<Sherbimi, Long> {
}
