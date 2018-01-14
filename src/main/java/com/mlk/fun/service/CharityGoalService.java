package com.mlk.fun.service;

import com.mlk.fun.domain.CharityGoal;
import com.mlk.fun.repo.CharityGoalRepository;
import com.mlk.fun.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CharityGoalService {

    @Autowired
    private CharityGoalRepository charityGoalRepository;

    public Response<List<CharityGoal>> getAllCharityGoals() {
        log.info("getAllCharityGoals");
        return new Response<List<CharityGoal>>(charityGoalRepository.findAll());
    }
}
