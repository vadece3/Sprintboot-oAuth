package com.vice.springboot.consultant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultantRepository
        extends JpaRepository<ConsultantModel, Integer> {


    //SELECT * FROM consultant WHERE consultantName = ?
    @Query("SELECT c FROM ConsultantModel c WHERE c.consultantName = ?1")
    Optional<ConsultantModel> findByConsultantName(String consultantName);

}
