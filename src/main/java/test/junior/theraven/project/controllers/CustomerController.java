package test.junior.theraven.project.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("customers")
    public ResponseEntity<CustomerDaoAdmin> createCustomer(@Valid @RequestBody CustomerDaoAdmin customerDaoAdmin) {

        return new ResponseEntity<>(customerService.createCustomer(customerDaoAdmin), HttpStatus.CREATED);

    }

    @GetMapping("customers")
    public ResponseEntity<List<CustomerDaoAdmin>> getCustomers(){


        return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);

    }


    @GetMapping("customers/{id}")
    public ResponseEntity<CustomerDaoAdmin> getCustomer(@PathVariable("id") Long id){

        if(id == null){
            throw new NullPointerException("Your id is null");
        }

        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);

    }


    @PutMapping("customers/{id}")
    public ResponseEntity<CustomerDaoAdmin> upgradeCustomer(@PathVariable("id") Long id,
                                                            @Valid @RequestBody CustomerDaoAdmin customerDaoAdmin){
        if(id != customerDaoAdmin.getId()){

            throw new IdAreNotEqualsException("Id must be equals, if not it can be problem in DB");
        }



        return new ResponseEntity<>(customerService.updateCustomer(customerDaoAdmin), HttpStatus.OK);
    }



    @DeleteMapping("customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id){

        customerService.deleteCustomerById(id);

        return new ResponseEntity<>("You have deleted customer with id: " + id, HttpStatus.OK);
    }


}
