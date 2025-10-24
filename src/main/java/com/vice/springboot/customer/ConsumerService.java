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

    public List<ConsumerModel> getConsumer1() {
        return consumerRepository.findAll();
    }

    public List<ConsumerModel> getConsumer2() {
        return List.of(
                new ConsumerModel(
                        1,
                        "testCustomerName",
                        "testCustomerCity",
                        "testContactPerson",
                        "testCustomerAddress",
                        "testGeolocalisation",
                        "testDateOfBirth"
                )
        );
    }

    public void addNewConsumer(ConsumerModel consumerModel) {
        Optional<ConsumerModel> consumerById = consumerRepository.
                findById(consumerModel.getConsumerId());
        if (consumerById.isPresent()) {
            throw new IllegalStateException("Id taken");
        }
        consumerRepository.save(consumerModel);
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

        ConsumerModel consumerModel = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new IllegalStateException(
                        "consumerModel with id " + consumerId + " does not exist"));
        if (customerName != null &&
                customerName.length() > 0 &&
                !Objects.equals(consumerModel.getCustomerName(), customerName)) {
            consumerModel.setCustomerName(customerName);
        }

        if (customerCity != null &&
                customerCity.length() > 0 &&
                !Objects.equals(consumerModel.getCustomerCity(), customerCity)) {
            consumerModel.setCustomerCity(customerCity);
        }

        if (profilePicture != null &&
                profilePicture.length() > 0 &&
                !Objects.equals(consumerModel.getContactsPerson(), profilePicture)) {
            consumerModel.setContactsPerson(profilePicture);
        }

        if (customerAddress != null &&
                customerAddress.length() > 0 &&
                !Objects.equals(consumerModel.getCustomerAddress(), customerAddress)) {
            consumerModel.setCustomerAddress(customerAddress);
        }

        if (geolocalisation != null &&
                geolocalisation.length() > 0 &&
                !Objects.equals(consumerModel.getGeolocalisation(), geolocalisation)) {
            consumerModel.setGeolocalisation(geolocalisation);
        }

        if (dateOfBirth != null &&
                dateOfBirth.length() > 0 &&
                !Objects.equals(consumerModel.getDateOfBirth(), dateOfBirth)) {
            consumerModel.setDateOfBirth(dateOfBirth);
        }
    }

}

