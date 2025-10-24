package com.vice.springboot.consultant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsultantRepository
        extends JpaRepository<Consultant, Integer> {


    //SELECT * FROM consultant WHERE consultantName = ?
    @Query("SELECT c FROM Consultant c WHERE c.consultantName = ?1")
    Optional<Consultant> findByConsultantName(String consultantName);

}
