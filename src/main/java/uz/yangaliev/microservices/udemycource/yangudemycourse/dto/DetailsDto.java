package uz.yangaliev.microservices.udemycource.yangudemycourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsDto {

    private Long employeeId;

    private String fullName;

    private String email;

    private String phoneNumber;
}
