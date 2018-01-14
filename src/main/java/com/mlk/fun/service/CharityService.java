package com.mlk.fun.service;

import com.mlk.fun.domain.Charity;
import com.mlk.fun.domain.CharityGoal;
import com.mlk.fun.repo.CharityGoalRepository;
import com.mlk.fun.repo.CharityRepository;
import com.mlk.fun.util.Response;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class CharityService {

    @Autowired
    private CharityRepository charityRepository;

    @Autowired
    private CharityGoalRepository charityGoalRepository;


    public Response<List<Charity>> getAllCharities() {
       log.info("getAllCharities");
       return new Response<List<Charity>>(charityRepository.findAll());
    }

    /**
     * Create a Charity Goal
     * @param charityId
     * @param goalId
     * @return
     */
    public Response<Charity> createCharityGoal(@NonNull Long charityId, @NonNull Long goalId) {

        // Find charity
        Charity charity = charityRepository.findOne(charityId);

        // Find goal
        CharityGoal charityGoal = charityGoalRepository.findOne(goalId);

        charityGoal.getCharities().add(charity);
        charityGoalRepository.save(charityGoal);

        return new Response<Charity>(charityRepository.getOne(charityId));
    }
}
