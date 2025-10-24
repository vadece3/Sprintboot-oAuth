package com.vice.springboot.customer;

import com.vice.springboot.Role.Role;
import com.vice.springboot.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin

public class ConsumerController {
    //	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//
    private final ConsumerService consumerService;
    private final ConsumerRepository consumerRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public ConsumerController(ConsumerRepository consumerRepository, ConsumerService consumerService, RoleRepository roleRepository) {

        this.consumerRepository = consumerRepository;
        this.consumerService = consumerService;
        this.roleRepository = roleRepository;
    }

    @RequestMapping(path = "api/v1/consumer1")
    @GetMapping
    public List<Consumer> getConsumer1() {
        return consumerService.getConsumer1();
    }

    @RequestMapping(path = "api/v1/storeNewConsumer")
    @PostMapping
    public ResponseEntity<Consumer> createConsumer(@RequestBody ConsumerRequest consumerRequest) {
        Consumer consumer = new Consumer();
        consumer.setCustomerName(consumerRequest.getCustomerName());
        consumer.setCustomerCity(consumerRequest.getCustomerCity());
        consumer.setContactsPerson(consumerRequest.getContactsPerson());
        consumer.setCustomerAddress(consumerRequest.getCustomerAddress());
        consumer.setGeolocalisation(consumerRequest.getGeolocalisation());
        consumer.setDateOfBirth(consumerRequest.getDateOfBirth());

        // Fetch roles by IDs
        Set<Role> roles = new HashSet<>(roleRepository.findAllById(consumerRequest.getRoleIds()));
        consumer.setRoles(roles);

        Consumer saved = consumerRepository.save(consumer);
        return ResponseEntity.ok(saved);
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

