package com.mlk.fun.config;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import com.mlk.fun.domain.Charity;
import com.mlk.fun.domain.CharityGoal;
import com.mlk.fun.domain.Donor;
import com.mlk.fun.dto.DonationDto;
import com.mlk.fun.dto.DonorDto;
import com.mlk.fun.service.CharityGoalService;
import com.mlk.fun.service.CharityService;
import com.mlk.fun.service.DonationService;
import com.mlk.fun.service.DonorService;
import com.mlk.fun.util.Response;
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

    @RequestMapping(value="donation", method=RequestMethod.POST)
    public @ResponseBody ResponseEntity<DonationDto>createDonation(
            @RequestBody DonationDto donationDto) {
        log.info("createDonation");
        Response<DonationDto> response = donationService.createDonation(donationDto);
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }

    //Implement a GET endpoint that given a charityID, returns a list of the 10 Donors who gave the most in Donations.
    @RequestMapping(value="topDonors/{charityId}", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<Set<DonorDto>> getTop10Donors(
            @PathVariable("charityId") Long charityId
            ) {
        log.info("getTOp10Donors");
        Response<Set<DonorDto>> response = donorService.getTop10Donors(charityId);
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }

    //Implement a GET endpoint that given a donorId, a fromDate and a toDate, returns the list of Donations for that Donor in the given time period.
    @RequestMapping(value="donationsBy/{donorId}/from/{fromDate}/to/{toDate}", method=RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<DonationDto>> getDonationsByDonor(
            @PathVariable("donorId") Long donorId,
            @PathVariable("fromDate") String from,
            @PathVariable("toDate") String to
    ) {
        log.info("getDonationsByDonor");
        Response<List<DonationDto>> response = donationService.getDonationsByDonorInRange(donorId, toDate(from), toDate(to));
        return new ResponseEntity<>(response.getData(), HttpStatus.OK);
    }


    //String testDate = "29-Apr-2010,13:00:14 PM";
    DateFormat formatter = new SimpleDateFormat("d-MMM-yyyy,HH:mm:ss aaa");

    private Date toDate(String input) {
        try {
            return formatter.parse(input);
        }catch(Exception x) {
            return new Date(); // for now - just return today
        }
    }
}
