package uz.yangaliev.microservices.udemycource.yangudemycourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;

    private String name;

    private String surname;

    private LocalDate birthday;

    private DetailsV2Dto details;
}
