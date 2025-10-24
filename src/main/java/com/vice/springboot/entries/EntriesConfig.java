package com.vice.springboot.entries;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EntriesConfig {

    @Bean
    CommandLineRunner entriesCommandLineRunner(EntriesRepository repository) {
        return args -> {
            EntriesModel testentries = new EntriesModel(
                    0,
                    0,
                    "",
                    ""
            );

            repository.saveAll(List.of(testentries));
        };
    }

}

