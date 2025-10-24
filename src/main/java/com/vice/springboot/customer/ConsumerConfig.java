package com.vice.springboot.customer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConsumerConfig {

    @Bean
    CommandLineRunner consumerCommandLineRunner(ConsumerRepository repository) {
        return args -> {
//            Consumer testuser = new Consumer(
//                    "testuser",
//                    "Bayern",
//                    "",
//                    "",
//                    "",
//                    ""
//            );
//
//            Consumer Admin = new Consumer(
//                    "Admin",
//                    "Braunschweig",
//                    "",
//                    "",
//                    "",
//                    ""
//            );

//            repository.saveAll(List.of(Admin, testuser));
        };
    }

}

