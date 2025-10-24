package com.vice.springboot.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProjectConfig {

    @Bean
    CommandLineRunner projectCommandLineRunner(ProjectRepository repository) {
        return args -> {
            ProjectModel testproject = new ProjectModel(
                    "testproject",
                    0,
                    0,
                    "",
                    "",
                    "not_done"
            );

            repository.saveAll(List.of(testproject));
        };
    }

}

