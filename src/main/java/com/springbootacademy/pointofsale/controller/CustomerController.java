package com.springbootacademy.pointofsale.controller;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.saveCustomer(customerDTO);
        return "Saved the customer";
    }

    @PutMapping("/update")
    public String updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

    @GetMapping(path = "/get_by_id", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId){
        CustomerDTO customerDTO = customerService.findById(customerId);
        return customerDTO;
    }

    @GetMapping(path = "/get_all_customers")
    public List<CustomerDTO> getAllCustomers(){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        return allCustomers;
    }

    @DeleteMapping(path = "delete/{id}")
    public String deleteCustomer(@PathVariable(value = "id") int customerId){
        String delete = customerService.deleteCustomer(customerId);
        return delete;
    }

    @GetMapping(path = "get_all_customers_by_status/{status}")
    public List<CustomerDTO> getAllCustomersByStatus(@PathVariable (value = "status") boolean activeStatus){
        List<CustomerDTO> customerDTOList = customerService.getAllCustomersByStatus(activeStatus);
        return customerDTOList;
    }

}
