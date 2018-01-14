package com.mlk.fun.repo;

import com.mlk.fun.domain.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {
}
