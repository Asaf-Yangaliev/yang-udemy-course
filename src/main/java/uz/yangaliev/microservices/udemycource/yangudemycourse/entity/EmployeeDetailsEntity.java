package uz.yangaliev.microservices.udemycource.yangudemycourse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "employee_details")
public class EmployeeDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "details")
    private EmployeeEntity employee;
}
