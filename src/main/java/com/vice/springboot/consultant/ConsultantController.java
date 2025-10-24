package com.vice.springboot.consultant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

public class ConsultantController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final ConsultantService consultantService;

    @Autowired
    public ConsultantController(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @RequestMapping(path = "api/v1/consultant1")
    @GetMapping
    public List<Consultant> getConsultant1() {
        return consultantService.getConsultant1();
    }

    @RequestMapping(path = "api/v1/consultant2")
    @GetMapping
    public List<Consultant> getConsultant2() {
        return consultantService.getConsultant2();
    }

    @RequestMapping(path = "api/v1/storeNewConsultant")
    @PostMapping
    public String postConsultant(@RequestBody Consultant consultant) {
        consultantService.addNewConsultant(consultant);
        return "New Consultant Added";
    }

    @RequestMapping(path = "api/v1/deleteConsultant/{consultantId}")
    @DeleteMapping
    public void deleteConsultant(@PathVariable("consultantId") Integer consultantId) {
        consultantService.deleteConsultant(consultantId);
    }

    @RequestMapping(path = "api/v1/deleteConsultant")
    @DeleteMapping
    public void deleteConsultant1(@RequestBody Integer consultantId) {
        consultantService.deleteConsultant(consultantId);
    }

    @RequestMapping(path = "api/v1/updateConsultant/{consultantName}")
    @PutMapping
    public void updateConsultant1(
            @PathVariable("consultantName") String consultantName,
            @RequestParam(required = false) String availability,
            @RequestParam(required = false) String profilePicture,
            @RequestParam(required = false) Integer consultantWorkLoad) {
        consultantService.updateConsultant( consultantName, availability, profilePicture, consultantWorkLoad);
    }

    @RequestMapping(path = "api/v1/updateConsultant")
    @PutMapping
    public void updateConsultant2(
            @RequestParam(required = false) String consultantName,
            @RequestParam(required = false) String availability,
            @RequestParam(required = false) String profilePicture,
            @RequestParam(required = false) Integer consultantWorkLoad) {
        consultantService.updateConsultant(consultantName, availability, profilePicture, consultantWorkLoad);
    }

}

