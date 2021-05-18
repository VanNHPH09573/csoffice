package com.example.cs_office.Controller;

import com.example.cs_office.Model.Customer;
import com.example.cs_office.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //list customer
    @GetMapping()
    public List<Customer> getCustomer() {
        return customerService.getCustomer();
    }

    //list customer by status == fasle
    @GetMapping("/false")
    public List<Customer> getCustomerByStatusFalse() {
        return customerService.getCustomerByStatus(false);
    }

    //list customer by status == true
    @GetMapping("/true")
    public List<Customer> getCustomerByStatusTrue() {
        return customerService.getCustomerByStatus(true);
    }

    // insert customer
    @PostMapping
    public void insertCustomer(@RequestBody Customer customer) {
        customerService.addNewCustomer(customer);
    }

    //search customer by id
    @GetMapping(path = "{customerId}")
    public Optional<Customer> getById(
            @PathVariable("customerId") int customerId) {
        return customerService.getById(customerId);
    }

    //delete customer by id
    @DeleteMapping(path = "{customerId}")
    public void deleteCustomer(
            @PathVariable("customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }

    //update customer by id
    @PutMapping(path = "{customerId}")
    public void updateCustomer(
            @PathVariable("customerId") int customerId,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String fisrtName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Date createDate,
            @RequestParam(required = false) boolean status
    ) {
        customerService.updateCustomer(customerId, phoneNumber, email, password, fisrtName, lastName, address, createDate, status);
    }

    //forgot password customer by id
    @GetMapping("/forgot")
    public void forgotPassword(
            @RequestParam(required = false) String email
    ) {
        customerService.forgotPassword(email);
    }
}
