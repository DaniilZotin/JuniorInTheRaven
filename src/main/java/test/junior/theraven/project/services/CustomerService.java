package test.junior.theraven.project.services;

import test.junior.theraven.project.dao.CustomerDaoAdmin;

import java.util.List;

public interface CustomerService {

    CustomerDaoAdmin createCustomer(CustomerDaoAdmin customerDaoAdmin);

    List<CustomerDaoAdmin> getCustomers();

    CustomerDaoAdmin getCustomerById(Long id);

    CustomerDaoAdmin updateCustomer(CustomerDaoAdmin customerDaoAdmin);

    void deleteCustomerById(Long id);
}
