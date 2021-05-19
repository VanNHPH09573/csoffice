package com.example.cs_office.Controller;


import com.example.cs_office.Model.DateMaster;
import com.example.cs_office.Service.DateMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/datemaster")
public class DateMasterController {

    private DateMasterService dateMasterService;

    @Autowired
    public DateMasterController(DateMasterService dateMasterService) {
        this.dateMasterService = dateMasterService;
    }

    //list dateMaster
    @GetMapping()
    public List<DateMaster> getDateMaster() {
        return dateMasterService.getDateMaster();
    }

    //list dateMaster by status == fasle
    @GetMapping("/false")
    public List<DateMaster> getDateMasterByStatusFalse() {
        return dateMasterService.getDateMasterByStatus(false);
    }

    //list dateMaster by status == true
    @GetMapping("/true")
    public List<DateMaster> getDateMasterByStatusTrue() {
        return dateMasterService.getDateMasterByStatus(true);
    }

//    // insert dateMaster
//    @PostMapping
//    public void insertCustomer(@RequestBody Customer customer) {
//        customerService.addNewCustomer(customer);
//    }
//
//    //search customer by id
//    @GetMapping(path = "{customerId}")
//    public Optional<Customer> getById(
//            @PathVariable("customerId") int customerId) {
//        return customerService.getById(customerId);
//    }
//
//    //delete customer by id
//    @DeleteMapping(path = "{customerId}")
//    public void deleteCustomer(
//            @PathVariable("customerId") int customerId) {
//        customerService.deleteCustomer(customerId);
//    }
//
//    //update customer by id
//    @PutMapping(path = "{customerId}")
//    public void updateCustomer(
//            @PathVariable("customerId") int customerId,
//            @RequestParam(required = false) String phoneNumber,
//            @RequestParam(required = false) String email,
//            @RequestParam(required = false) String password,
//            @RequestParam(required = false) String fisrtName,
//            @RequestParam(required = false) String lastName,
//            @RequestParam(required = false) String address,
//            @RequestParam(required = false) Date createDate,
//            @RequestParam(required = false) boolean status
//    ) {
//        customerService.updateCustomer(customerId, phoneNumber, email, password, fisrtName, lastName, address, createDate, status);
//    }

}
