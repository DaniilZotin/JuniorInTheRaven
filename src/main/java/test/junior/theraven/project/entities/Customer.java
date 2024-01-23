package test.junior.theraven.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import test.junior.theraven.project.common.ApplicationConstants;

@Data
@Entity
@Table(name = "customers")
public class Customer {


    public Customer() {
        this.created = System.currentTimeMillis();
        this.updated = System.currentTimeMillis();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "created")
    private Long created;

    @Column(name = "updated")
    private Long updated;

    @Size(min = ApplicationConstants.DataValidation.MIN_SIZE_OF_FULL_NAME,
    max = ApplicationConstants.DataValidation.MAX_SIZE_OF_FULL_NAME)
    @Column(name = "full_name")
    private String full_name;

    @Size(min = ApplicationConstants.DataValidation.MIN_SIZE_OF_EMAIL,
            max = ApplicationConstants.DataValidation.MAX_SIZE_OF_EMAIL)
    @Pattern(regexp = "[^@]+@[^@]+", message = "Invalid email format")
    @Column(name = "email", unique = true)
    private String email;

    @Size(min = ApplicationConstants.DataValidation.MIN_SIZE_OF_PHONE,
            max = ApplicationConstants.DataValidation.MAX_SIZE_OF_PHONE)
    @Pattern(regexp = "\\+\\d{5,13}", message = "Phone must start with '+' and contain only digits")
    @Column(name = "phone")
    private String phone;

    @Column(name = "is_active")
    private boolean is_active;



}
