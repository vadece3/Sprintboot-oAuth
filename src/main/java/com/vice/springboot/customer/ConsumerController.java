package com.vice.springboot.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin

public class ConsumerController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final ConsumerService consumerService;

    @Autowired
    public ConsumerController(ConsumerService consumerService) {
        this.consumerService = consumerService;
    }

    @RequestMapping(path = "api/v1/consumer1")
    @GetMapping
    public List<ConsumerModel> getConsumer1() {
        return consumerService.getConsumer1();
    }

    @RequestMapping(path = "api/v1/consumer2")
    @GetMapping
    public List<ConsumerModel> getConsumer2() {
        return consumerService.getConsumer2();
    }

    @RequestMapping(path = "api/v1/storeNewConsumer")
    @PostMapping
    public String postConsumer(@RequestBody ConsumerModel consumerModel) {
        consumerService.addNewConsumer(consumerModel);
        return "New Cosumer Added";
    }

    @RequestMapping(path = "api/v1/deleteconsumer/{consumerId}")
    @DeleteMapping
    public void deleteConsumer(@PathVariable("consumerId") Integer consumerId) {
        consumerService.deleteConsumer(consumerId);
    }

    @RequestMapping(path = "api/v1/deleteconsumer")
    @DeleteMapping
    public void deleteConsumer1(@RequestBody Integer consumerId) {
        consumerService.deleteConsumer(consumerId);
    }

    @RequestMapping(path = "api/v1/updateconsumer/{consumerId}")
    @PutMapping
    public void updateConsumer1(
            @PathVariable("consumerId") Integer consumerId,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String customerCity,
            @RequestParam(required = false) String contactsPerson,
            @RequestParam(required = false) String customerAddress,
            @RequestParam(required = false) String geolocalisation,
            @RequestParam(required = false) String dateOfBirth) {
        consumerService.updateConsumer(consumerId, customerName, customerCity, contactsPerson, customerAddress, geolocalisation, dateOfBirth);
    }

    @RequestMapping(path = "api/v1/updateconsumer")
    @PutMapping
    public void updateConsumer2(
            @RequestBody Integer consumerId,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) String customerCity,
            @RequestParam(required = false) String contactsPerson,
            @RequestParam(required = false) String customerAddress,
            @RequestParam(required = false) String geolocalisation,
            @RequestParam(required = false) String dateOfBirth) {
        consumerService.updateConsumer(consumerId, customerName, customerCity, contactsPerson, customerAddress, geolocalisation, dateOfBirth);
    }

}

