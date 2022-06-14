package com.example.laba4rsoi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("Surname", "Name", "Father Name", "Date Of birth", "Male", "Passport", "Email", "Position")));
            log.info("Preloading " + repository.save(new User("Dyachenko", "Maxim", "Vladimirovich", "24.04.01", "Male", "Passport", "lalala@gmail.com", "Student")));
        };
    }
}
