package com.mlk.fun.repo;

import com.mlk.fun.domain.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {

    @Query(nativeQuery = true, value="select d.* from Donor d, Donation dn, donation_charity dc, donation_donor dd, charity c where dc.donation_id=dn.id and dc.charity_id=c.id and dd.donor_id=d.id and c.id=:charityId order by dn.amount desc limit 10")
    List<Donor> findTop10ByCharityId(@Param("charityId")Long charityId);

}
