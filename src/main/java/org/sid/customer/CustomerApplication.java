package org.sid.customer;

import org.sid.customer.entities.Customer;
import org.sid.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
@RestController

public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }
@Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
          restConfiguration.exposeIdsFor(Customer.class);

        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);
            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Barry").email("barrysanoussa19@gmail.com").build(),

                            Customer.builder().name("Datadog").email("hassan@gmail.com").build(),

                            Customer.builder().name("Marry").email("youssouf@gmail.com").build()

                            )
            );
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer);
            }  );
        };
}
}
