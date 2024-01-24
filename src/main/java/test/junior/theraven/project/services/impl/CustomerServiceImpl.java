package test.junior.theraven.project.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.junior.theraven.project.dto.CustomerDto;
import test.junior.theraven.project.entities.Customer;
import test.junior.theraven.project.repositories.CustomerRepository;
import test.junior.theraven.project.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer newCustomer = new Customer();
        newCustomer.setPhone(customerDto.getPhone());
        newCustomer.setEmail(customerDto.getEmail());
        newCustomer.setFull_name(customerDto.getFullName());
        newCustomer.setCreated(System.currentTimeMillis());
        newCustomer.set_active(true);
        customerRepository.save(newCustomer);
        customerDto.setId(newCustomer.getId());
        return customerDto;
    }

    @Override
    public List<CustomerDto> getCustomers() {

        List<CustomerDto> allCustomers = new ArrayList<>();

        for(Customer el: customerRepository.findAll()){
            allCustomers.add(CustomerDto.mapToCustomerDaoAdmin(el));
        }

        return allCustomers;
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        return CustomerDto.mapToCustomerDaoAdmin(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {

        Customer existCustomer = customerRepository.findById(customerDto.getId()).get();

        System.out.println(existCustomer);

        existCustomer.setUpdated(System.currentTimeMillis());
        existCustomer.setPhone(customerDto.getPhone());

        existCustomer.setFull_name(customerDto.getFullName());

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        String formattedDateTime = dateFormat.format(new Date(existCustomer.getUpdated()));
//
//        System.out.println(formattedDateTime);


        Customer updatedCustomer = customerRepository.save(existCustomer);




        return new CustomerDto(updatedCustomer.getId(), updatedCustomer.getFull_name(),
                updatedCustomer.getEmail(), updatedCustomer.getPhone());
    }

    @Override
    public void deleteCustomerById(Long id) {

        Customer customerToDelete = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        customerToDelete.set_active(false);
        customerRepository.save(customerToDelete);
    }


}
