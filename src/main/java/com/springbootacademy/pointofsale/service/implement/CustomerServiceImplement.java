package com.springbootacademy.pointofsale.service.implement;

import com.springbootacademy.pointofsale.dto.CustomerDTO;
import com.springbootacademy.pointofsale.dto.request.CustomerUpdateDTO;
import com.springbootacademy.pointofsale.entity.Customer;
import com.springbootacademy.pointofsale.repository.CustomerRepository;
import com.springbootacademy.pointofsale.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplement implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerId(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.isActive());
        customerRepository.save(customer);
        System.out.println("Saved the customer");
        return customer.getCustomerAddress();
    }

    @Override
    public String deleteCustomer(CustomerDTO customerDTO) {
        customerRepository.deleteById(customerDTO.getCustomerId());
        return "Delete";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepository.existsById(customerUpdateDTO.getCustomerId())){
            Customer customer = customerRepository.getReferenceById(customerUpdateDTO.getCustomerId());

            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepository.save(customer);
            return customerUpdateDTO.getCustomerName() + " is updated successfully!";
        }else {
            throw new RuntimeException("no data found");
        }
    }

    @Override
    public CustomerDTO findById(int customerId) {
        if (customerRepository.existsById(customerId)){
            Customer customer = customerRepository.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;
        } else {
            throw new RuntimeException("Not found");
        }
    }
}
