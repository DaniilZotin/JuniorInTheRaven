package test.junior.theraven.project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.junior.theraven.project.dao.CustomerDaoAdmin;
import test.junior.theraven.project.exeptions.IdAreNotEqualsException;
import test.junior.theraven.project.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("customers")
    public ResponseEntity<CustomerDaoAdmin> createCustomer(@Valid @RequestBody CustomerDaoAdmin customerDaoAdmin) {
        CustomerDaoAdmin newCustomer = customerService.createCustomer(customerDaoAdmin);

        log.info("Was created new customer: {} ", newCustomer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerDaoAdmin>> getCustomers(){

        List<CustomerDaoAdmin> customers = customerService.getCustomers();

        if(customers!=null){
            log.info("List of customers is not null");
        }

        return new ResponseEntity<>(customers, HttpStatus.OK);

    }


    @GetMapping("customers/{id}")
    public ResponseEntity<CustomerDaoAdmin> getCustomer(@PathVariable("id") Long id){

        if(id == null){
            throw new NullPointerException("Your id is null");
        }

        CustomerDaoAdmin customerById = customerService.getCustomerById(id);

        log.info("Customer by id {} ", customerById);

        return new ResponseEntity<>(customerById, HttpStatus.OK);

    }


    @PutMapping("customers/{id}")
    public ResponseEntity<CustomerDaoAdmin> upgradeCustomer(@PathVariable("id") Long id,
                                                            @Valid @RequestBody CustomerDaoAdmin customerDaoAdmin){
        if(id != customerDaoAdmin.getId()){

            throw new IdAreNotEqualsException("Id must be equals, if not it can be problem in DB");
        }

        CustomerDaoAdmin updatedCustomer = customerService.updateCustomer(customerDaoAdmin);

        log.info("Updated customer {} ", updatedCustomer);

        return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
    }



    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){

        customerService.deleteCustomerById(id);

        log.info("Customer with id {} was deleted", id);

        return new ResponseEntity<>("You have deleted customer with id: " + id, HttpStatus.OK);
    }


}
