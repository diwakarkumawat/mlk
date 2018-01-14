package com.mlk.fun.service;

import com.mlk.fun.domain.Donation;
import com.mlk.fun.dto.DonationDto;
import com.mlk.fun.repo.CharityRepository;
import com.mlk.fun.repo.DonationRepository;
import com.mlk.fun.repo.DonorRepository;
import com.mlk.fun.util.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private CharityRepository charityRepository;

    public Response<List<Donation>> getAllDonations() {
        log.info("getAllDonations");
        return new Response<List<Donation>>(donationRepository.findAll());
    }

    public Response<DonationDto> createDonation(@NonNull DonationDto dto) {

        // Create new Donation
        Donation donation = new Donation();
        donation.setDonationDate(new Date()); // Today
        donation.setAmount(dto.getAmount());
        donation.getDonor().add(donorRepository.findOne(dto.getDonorId()));
        donation.getCharity().add(charityRepository.findOne(dto.getCharityId()));
        donation = donationRepository.save(donation);
        dto.setId(donation.getId());
        return new Response<DonationDto>(dto);
    }
}
