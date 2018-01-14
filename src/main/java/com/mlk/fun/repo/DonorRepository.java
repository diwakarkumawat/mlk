package com.mlk.fun.repo;

import com.mlk.fun.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    @Query(nativeQuery = true, value="select d.* from donation dn, donor d where dn.donor_id=d.id and dn.charity_id=:charityId order by dn.amount desc limit 10")
    List<Donor> findTop10ByCharityId(@Param("charityId")Long charityId);

}
