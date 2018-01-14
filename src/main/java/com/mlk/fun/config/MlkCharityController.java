package com.mlk.fun.config;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.mlk.fun.domain.Charity;
import com.mlk.fun.domain.CharityGoal;
import com.mlk.fun.domain.Donor;
import com.mlk.fun.service.CharityGoalService;
import com.mlk.fun.service.CharityService;
import com.mlk.fun.service.DonationService;
import com.mlk.fun.service.DonorService;
import com.mlk.fun.util.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mlk")
@Slf4j
public class MlkCharityController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private CharityService charityService;

    @Autowired
    private CharityGoalService charityGoalService;

    @Autowired
    private DonorService donorService;

    @Autowired
    private DonationService donationService;

    @RequestMapping(value="hello", method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        log.info("sayHello");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value="charities", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Charity>> getCharities() {
        log.info("getCharities");
        Response<List<Charity>> response = charityService.getAllCharities();
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);

    }

    @RequestMapping(value="donors", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Donor>> getDonors() {
        log.info("getDonors");
        Response<List<Donor>> response = donorService.getAllDonors();
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);

    }

    @RequestMapping(value="goals", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<CharityGoal>> getCharityGoals() {
        log.info("getGoals");
        Response<List<CharityGoal>> response = charityGoalService.getAllCharityGoals();
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }

    @RequestMapping(value="charityGoals", method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<Charity>createCharityGoals(
            @RequestBody Map<String, Long> requestJson) {
        log.info("createCharityGoals");
        Response<Charity> response = charityService.createCharityGoal(requestJson.get("charityId"), requestJson.get("goalId"));
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }
}
