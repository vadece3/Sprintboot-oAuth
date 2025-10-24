package com.vice.springboot.consultant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ConsultantService {

    private final ConsultantRepository consultantRepository;

    @Autowired
    public ConsultantService(ConsultantRepository consultantRepository) {
        this.consultantRepository = consultantRepository;
    }

    public List<ConsultantModel> getConsultant1() {
        return consultantRepository.findAll();
    }

    public List<ConsultantModel> getConsultant2() {
        return List.of(
                new ConsultantModel(
                        1,
                        "testConsultantName",
                        "not available",
                        "testprofilePicture",
                        0
                )
        );
    }

    public void addNewConsultant(ConsultantModel consultantModel) {
        Optional<ConsultantModel> consultantByName = consultantRepository.
                findByConsultantName(consultantModel.getConsultantName());
        if (consultantByName.isPresent()) {
            throw new IllegalStateException("name is already taken");
        } else {
            consultantRepository.save(consultantModel);
        }
    }
    public void deleteConsultant(Integer consultantId) {
        boolean exists = consultantRepository.existsById(consultantId);
        if (!exists) {
            throw new IllegalStateException(
                    "consultant with id " + consultantId + " does not exists");
        } else {
            consultantRepository.deleteById(consultantId);
        }
    }

    @Transactional
    public void updateConsultant(
            String consultantName,
            String availability,
            String profilePicture,
            Integer consultantWorkLoad) {

        ConsultantModel consultantModel = consultantRepository.findByConsultantName(consultantName)
                .orElseThrow(() -> new IllegalStateException(
                        "consultantModel with name " + consultantName + " does not exist"));

        Optional<ConsultantModel> consultantOptional = consultantRepository
                .findByConsultantName(consultantName);
        if (consultantOptional.isPresent()) {
            throw new IllegalStateException("consultantModel name already exist");
        } else {
            if (consultantName != null &&
                    consultantName.length() > 0 &&
                    !Objects.equals(consultantModel.getConsultantName(), consultantName)) {
                consultantModel.setConsultantName(consultantName);
            }

            if (availability != null &&
                    availability.length() > 0 &&
                    !Objects.equals(consultantModel.getAvailability(), availability)) {
                consultantModel.setAvailability(availability);
            }

            if (profilePicture != null &&
                    profilePicture.length() > 0 &&
                    !Objects.equals(consultantModel.getProfilePicture(), profilePicture)) {
                consultantModel.setProfilePicture(profilePicture);
            }

            if (consultantWorkLoad != null &&
                    consultantWorkLoad > 0 &&
                    !Objects.equals(consultantModel.getConsultantWorkLoad(), consultantWorkLoad)) {
                consultantModel.setConsultantWorkLoad(consultantWorkLoad);
            }

        }
    }

}

