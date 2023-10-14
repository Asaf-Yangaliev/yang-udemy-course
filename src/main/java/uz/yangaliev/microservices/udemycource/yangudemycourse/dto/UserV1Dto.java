package uz.yangaliev.microservices.udemycource.yangudemycourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserV1Dto {
    private String name;
    private String surname;
}
