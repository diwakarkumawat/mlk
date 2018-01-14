package com.mlk.fun.dto;

import com.mlk.fun.domain.Donation;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DonationDto implements Serializable {
    private Long id;
    private BigDecimal amount;
    private Long donorId;
    private Long charityId;

    public DonationDto(Donation donation) {
        setId(donation.getId());
        setAmount(donation.getAmount());
        setDonorId(donation.getDonor().getId());
        setCharityId(donation.getCharity().getId());
    }
}
