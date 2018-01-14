package com.mlk.fun.dto;

import com.mlk.fun.domain.Donation;
import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DonationDto implements Serializable {
    private Long id;
    private BigDecimal amount;
    private String donationDate;
    private Long donorId;
    private Long charityId;

    public DonationDto() {
    }

    public DonationDto(Donation donation) {
        setId(donation.getId());
        setAmount(donation.getAmount());
        setDonorId(donation.getDonor().getId());
        setCharityId(donation.getCharity().getId());
        setDonationDate(donation.getDonationDate().toString());
    }
}
