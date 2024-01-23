package test.junior.theraven.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.junior.theraven.project.entities.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
