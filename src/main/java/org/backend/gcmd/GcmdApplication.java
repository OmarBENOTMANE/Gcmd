package org.backend.gcmd;

import org.backend.gcmd.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class GcmdApplication implements CommandLineRunner {
    @Autowired
    CommandeRepository cmdRepository ;

    public static void main(String[] args) {
        SpringApplication.run(GcmdApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
    
}

