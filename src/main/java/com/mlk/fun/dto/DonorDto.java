package com.mlk.fun.dto;

import com.mlk.fun.domain.Donor;
import lombok.Data;
import lombok.NonNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class DonorDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;

    public DonorDto(@NonNull Donor donor) {
        this.id = donor.getId();
        this.email = donor.getEmail();
        this.firstName = donor.getFirstName();
        this.lastName = donor.getLastName();
    }
}
