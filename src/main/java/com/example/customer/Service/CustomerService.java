package com.example.customer.Service;

import com.example.customer.Entity.Customer;
import com.example.customer.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public Customer getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found: " + id));
    }

    public Customer save(Customer customer) {

        return repository.save(customer);
    }

    public Customer update(Long id, Customer request) {
        Customer existing = getById(id);

        existing.setEmail(request.getEmail());
        existing.setName(request.getName());
        existing.setAddress(request.getAddress());

        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}