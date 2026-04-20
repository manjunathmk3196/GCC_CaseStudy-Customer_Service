package com.example.customer.Controller;

import com.example.customer.Entity.Customer;
import com.example.customer.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
@Tag(name = "Customer Management", description = "APIs for managing customers")
public class CustomerController {

    private final CustomerService service;

    @GetMapping
    @Operation(summary = "Get all customers", description = "Retrieve a list of all customers")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved all customers")
    public List<Customer> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID", description = "Retrieve a specific customer by their ID")
    @ApiResponse(responseCode = "200", description = "Customer found")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public Customer getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    @Operation(summary = "Create a new customer", description = "Create a new customer with email, first name, and last name")
    @ApiResponse(responseCode = "200", description = "Customer successfully created")
    @ApiResponse(responseCode = "400", description = "Invalid input data")
    public Customer create(@RequestBody Customer c) {
        return service.save(c);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer", description = "Update an existing customer's information")
    @ApiResponse(responseCode = "200", description = "Customer successfully updated")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public Customer update(@PathVariable String id, @RequestBody Customer c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete customer", description = "Delete a customer by their ID")
    @ApiResponse(responseCode = "200", description = "Customer successfully deleted")
    @ApiResponse(responseCode = "404", description = "Customer not found")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}