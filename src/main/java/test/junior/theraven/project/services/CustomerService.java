package test.junior.theraven.project.services;

import test.junior.theraven.project.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customerDto);

    List<CustomerDto> getCustomers();

    CustomerDto getCustomerById(Long id);

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomerById(Long id);
}
