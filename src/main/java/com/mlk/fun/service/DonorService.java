package com.mlk.fun.service;

import com.mlk.fun.domain.Donor;
import com.mlk.fun.dto.DonorDto;
import com.mlk.fun.repo.DonorRepository;
import com.mlk.fun.util.Response;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public Response<List<Donor>> getAllDonors() {
        log.info("getAllDonors");
        return new Response<List<Donor>>(donorRepository.findAll());
    }

    public Response<Set<DonorDto>> getTop10Donors(@NonNull Long charityId) {
        log.info("getTop10Donors");
        List<Donor> donors = donorRepository.findTop10ByCharityId(charityId);
        return new Response<Set<DonorDto>>(toDto(donors));
    }

    private Set<DonorDto> toDto(List<Donor> donors) {
        return donors.stream().map(donor -> {
            return new DonorDto(donor);
        }).collect(Collectors.toSet());
    }
}
