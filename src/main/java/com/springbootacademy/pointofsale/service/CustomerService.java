package com.springbootacademy.pointofsale.service;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String deleteCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    CustomerDTO findById(int customerId);
}
