package test.junior.theraven.project.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import test.junior.theraven.project.entities.Customer;

@Data
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    @NotBlank(message = "Full name cannot be blank")
    private String fullName;
    private String email;

    @NotBlank(message = "Full name cannot be blank")
    private String phone;


    public static CustomerDto mapToCustomerDaoAdmin (Customer customer){

        return new CustomerDto(customer.getId(),customer.getFull_name(), customer.getEmail() , customer.getPhone() );
    }
}
