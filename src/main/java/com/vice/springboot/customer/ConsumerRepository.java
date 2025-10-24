package com.vice.springboot.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository
        extends JpaRepository<Consumer, Integer> {

}
