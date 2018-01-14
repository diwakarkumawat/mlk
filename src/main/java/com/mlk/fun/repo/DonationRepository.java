package com.mlk.fun.repo;

import com.mlk.fun.domain.Donation;
import com.mlk.fun.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    List<Donation> findAllByDonorAndDonationDateBetween(Donor donor, Date from, Date to);

}
