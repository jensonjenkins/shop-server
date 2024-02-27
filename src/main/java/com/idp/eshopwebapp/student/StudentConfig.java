package com.idp.eshopwebapp.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Autowired
    StudentRepository repository;
    @Bean
    CommandLineRunner commandLineRunner(
    ){
        return args -> {
            System.out.println("RUNNING COMMAND LINE RUNNER");
            Student s1 = new Student(
                    "Kent",
                    87);
            Student s3 = new Student(
                    "While",
                    1756);
            Student s2 = new Student(
                    "Kenneth",
                    654);
            repository.saveAll(
                    List.of(s1, s2, s3)
            );
            System.out.println("DONE RUNNING");
        };
    }
}
