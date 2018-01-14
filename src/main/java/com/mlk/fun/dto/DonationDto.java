package com.mlk.fun.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class DonationDto implements Serializable {
    private Long id;
    private BigDecimal amount;
    private Long donorId;
    private Long charityId;
}
