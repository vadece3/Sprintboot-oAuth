package com.vice.springboot.entries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntriesRepository
        extends JpaRepository<Entries, Integer> {
}
