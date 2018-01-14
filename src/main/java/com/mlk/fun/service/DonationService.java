package com.mlk.fun.service;

import com.mlk.fun.domain.Donation;
import com.mlk.fun.repo.DonationRepository;
import com.mlk.fun.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    public Response<List<Donation>> getAllDonations() {
        log.info("getAllDonations");
        return new Response<List<Donation>>(donationRepository.findAll());
    }
}
