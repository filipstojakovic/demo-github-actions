package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
class CustomerController {

    private final CustomerRepository repo;

    @GetMapping("/api/customers")
    List<Customer> getAll() {
        return repo.findAll();
    }
}
