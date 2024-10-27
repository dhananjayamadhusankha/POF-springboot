package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO findById(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomer(int customerId);

    List<CustomerDTO> getAllCustomersByStatus(boolean activeStatus);
}
