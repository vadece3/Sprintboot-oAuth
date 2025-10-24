package com.vice.springboot.consultant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConsultantConfig {

    @Bean
    CommandLineRunner consultantCommandLineRunner(ConsultantRepository repository) {
        return args -> {
            Consultant testconsultant = new Consultant(
                    "testconsultant",
                    "not_available",
                    "",
                    0
            );

//            repository.saveAll(List.of(testconsultant));
        };
    }

}

