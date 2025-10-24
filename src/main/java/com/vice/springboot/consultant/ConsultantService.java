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

    public List<Consultant> getConsultant1() {
        return consultantRepository.findAll();
    }

    public List<Consultant> getConsultant2() {
        return List.of(
                new Consultant(
                        "testConsultantName",
                        "not available",
                        "testprofilePicture",
                        0
                )
        );
    }

    public void addNewConsultant(Consultant consultant) {
        Optional<Consultant> consultantByName = consultantRepository.
                findByConsultantName(consultant.getConsultantName());
        if (consultantByName.isPresent()) {
            throw new IllegalStateException("name is already taken");
        } else {
            consultantRepository.save(consultant);
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

        Consultant consultant = consultantRepository.findByConsultantName(consultantName)
                .orElseThrow(() -> new IllegalStateException(
                        "consultant with name " + consultantName + " does not exist"));

        Optional<Consultant> consultantOptional = consultantRepository
                .findByConsultantName(consultantName);
        if (consultantOptional.isPresent()) {
            throw new IllegalStateException("consultant name already exist");
        } else {
            if (consultantName != null &&
                    consultantName.length() > 0 &&
                    !Objects.equals(consultant.getConsultantName(), consultantName)) {
                consultant.setConsultantName(consultantName);
            }

            if (availability != null &&
                    availability.length() > 0 &&
                    !Objects.equals(consultant.getAvailability(), availability)) {
                consultant.setAvailability(availability);
            }

            if (profilePicture != null &&
                    profilePicture.length() > 0 &&
                    !Objects.equals(consultant.getProfilePicture(), profilePicture)) {
                consultant.setProfilePicture(profilePicture);
            }

            if (consultantWorkLoad != null &&
                    consultantWorkLoad > 0 &&
                    !Objects.equals(consultant.getConsultantWorkLoad(), consultantWorkLoad)) {
                consultant.setConsultantWorkLoad(consultantWorkLoad);
            }

        }
    }

}

