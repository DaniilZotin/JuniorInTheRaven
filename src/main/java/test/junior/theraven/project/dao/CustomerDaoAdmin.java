package test.junior.theraven.project.dao;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import test.junior.theraven.project.entities.Customer;

@Data
@AllArgsConstructor
public class CustomerDaoAdmin {

    private Long id;

    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    private String email;

    @NotBlank(message = "Full name cannot be blank")
    private String phone;


    public static CustomerDaoAdmin mapToCustomerDaoAdmin (Customer customer){

        return new CustomerDaoAdmin(customer.getId(),customer.getFull_name(), customer.getEmail() , customer.getPhone() );
    }
}
