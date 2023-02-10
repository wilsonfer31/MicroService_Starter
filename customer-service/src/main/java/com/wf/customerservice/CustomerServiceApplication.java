package com.wf.customerservice;

import com.wf.customerservice.entities.Customer;
import com.wf.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Wilson").email("wfernandes@gmail.com").build(),
                    Customer.builder().name("Wilson2").email("wfernandes2@gmail.com").build(),
                    Customer.builder().name("Wilson3").email("wfernandes2@gmail.com").build()
            ));

            customerRepository.findAll().forEach(System.out::println);
        };
    }

}
