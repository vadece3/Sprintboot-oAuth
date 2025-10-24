package com.vice.springboot.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsumerService {

    private final ConsumerRepository consumerRepository;

    @Autowired
    public ConsumerService(ConsumerRepository consumerRepository) {
        this.consumerRepository = consumerRepository;
    }

    public List<Consumer> getConsumer1() {
        return consumerRepository.findAll();
    }

    public void addNewConsumer(Consumer consumer) {
        consumerRepository.save(consumer);
    }

    public void deleteConsumer(Integer consumerId) {
        boolean exists = consumerRepository.existsById(consumerId);
        if (!exists) {
            throw new IllegalStateException(
                    "consumer with id " + consumerId + " does not exists");
        } else {
            consumerRepository.deleteById(consumerId);
        }
    }

    @Transactional
    public void updateConsumer(
            Integer consumerId,
            String customerName,
            String customerCity,
            String profilePicture,
            String customerAddress,
            String geolocalisation,
            String dateOfBirth) {

        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new IllegalStateException(
                        "consumer with id " + consumerId + " does not exist"));
        if (customerName != null &&
                customerName.length() > 0 &&
                !Objects.equals(consumer.getCustomerName(), customerName)) {
            consumer.setCustomerName(customerName);
        }

        if (customerCity != null &&
                customerCity.length() > 0 &&
                !Objects.equals(consumer.getCustomerCity(), customerCity)) {
            consumer.setCustomerCity(customerCity);
        }

        if (profilePicture != null &&
                profilePicture.length() > 0 &&
                !Objects.equals(consumer.getContactsPerson(), profilePicture)) {
            consumer.setContactsPerson(profilePicture);
        }

        if (customerAddress != null &&
                customerAddress.length() > 0 &&
                !Objects.equals(consumer.getCustomerAddress(), customerAddress)) {
            consumer.setCustomerAddress(customerAddress);
        }

        if (geolocalisation != null &&
                geolocalisation.length() > 0 &&
                !Objects.equals(consumer.getGeolocalisation(), geolocalisation)) {
            consumer.setGeolocalisation(geolocalisation);
        }

        if (dateOfBirth != null &&
                dateOfBirth.length() > 0 &&
                !Objects.equals(consumer.getDateOfBirth(), dateOfBirth)) {
            consumer.setDateOfBirth(dateOfBirth);
        }
    }

}

