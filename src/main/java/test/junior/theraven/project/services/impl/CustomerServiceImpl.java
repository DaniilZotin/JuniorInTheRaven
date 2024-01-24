package test.junior.theraven.project.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.junior.theraven.project.dao.CustomerDaoAdmin;
import test.junior.theraven.project.entities.Customer;
import test.junior.theraven.project.repositories.CustomerRepository;
import test.junior.theraven.project.services.CustomerService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerDaoAdmin createCustomer(CustomerDaoAdmin customerDaoAdmin) {
        Customer newCustomer = new Customer();
        newCustomer.setPhone(customerDaoAdmin.getPhone());
        newCustomer.setEmail(customerDaoAdmin.getEmail());
        newCustomer.setFull_name(customerDaoAdmin.getFullName());
        newCustomer.setCreated(System.currentTimeMillis());
        newCustomer.set_active(true);
        customerRepository.save(newCustomer);
        customerDaoAdmin.setId(newCustomer.getId());
        return customerDaoAdmin;
    }

    @Override
    public List<CustomerDaoAdmin> getCustomers() {

        List<CustomerDaoAdmin> allCustomers = new ArrayList<>();

        for(Customer el: customerRepository.findAll()){
            allCustomers.add(CustomerDaoAdmin.mapToCustomerDaoAdmin(el));
        }

        return allCustomers;
    }

    @Override
    public CustomerDaoAdmin getCustomerById(Long id) {
        return CustomerDaoAdmin.mapToCustomerDaoAdmin(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDaoAdmin updateCustomer(CustomerDaoAdmin customerDaoAdmin) {

        Customer existCustomer = customerRepository.findById(customerDaoAdmin.getId()).get();

        System.out.println(existCustomer);

        existCustomer.setUpdated(System.currentTimeMillis());
        existCustomer.setPhone(customerDaoAdmin.getPhone());

        existCustomer.setFull_name(customerDaoAdmin.getFullName());

//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        String formattedDateTime = dateFormat.format(new Date(existCustomer.getUpdated()));
//
//        System.out.println(formattedDateTime);


        Customer updatedCustomer = customerRepository.save(existCustomer);




        return new CustomerDaoAdmin(updatedCustomer.getId(), updatedCustomer.getFull_name(),
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
