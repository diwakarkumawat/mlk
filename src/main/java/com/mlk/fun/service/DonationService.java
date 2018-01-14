package com.mlk.fun.service;

import com.mlk.fun.config.MlkCharityController;
import com.mlk.fun.domain.Donation;
import com.mlk.fun.dto.DonationDto;
import com.mlk.fun.repo.CharityRepository;
import com.mlk.fun.repo.DonationRepository;
import com.mlk.fun.repo.DonorRepository;
import com.mlk.fun.util.DateUtil;
import com.mlk.fun.util.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DonationService {

    @Autowired
    private DonationRepository donationRepository;

    @Autowired
    private DonorRepository donorRepository;

    @Autowired
    private CharityRepository charityRepository;

    public Response<List<DonationDto>> getAllDonations() {
        log.info("getAllDonations");
        List<Donation> donations = donationRepository.findAll();
        return new Response(donations.stream().map( donation -> new DonationDto(donation)).collect(Collectors.toList()));
    }

    public Response<List<DonationDto>> getDonationsByDonorInRange(Long donorId, Date from, Date to) {
        List<Donation> donations = donationRepository.findAllByDonorAndDonationDateBetween(donorRepository.findOne(donorId), from, to);
        return new Response(donations.stream().map( donation -> new DonationDto(donation)).collect(Collectors.toList()));
    }

    public Response<DonationDto> createDonation(@NonNull DonationDto dto) {
        // Create new Donation
        Donation donation = new Donation();
        donation.setDonationDate(DateUtil.toDate(dto.getDonationDate()));
        donation.setAmount(dto.getAmount());
        donation.setDonor(donorRepository.findOne(dto.getDonorId()));
        donation.setCharity(charityRepository.findOne(dto.getCharityId()));
        donation = donationRepository.save(donation);
        dto.setId(donation.getId());
        return new Response<DonationDto>(dto);
    }
}
