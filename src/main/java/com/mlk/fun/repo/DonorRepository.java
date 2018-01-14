package com.mlk.fun.repo;

import com.mlk.fun.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonorRepository extends JpaRepository<Donor, Long> {
}
