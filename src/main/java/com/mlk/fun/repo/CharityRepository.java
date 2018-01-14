package com.mlk.fun.repo;

import com.mlk.fun.domain.Charity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityRepository extends JpaRepository<Charity, Long> {
}
