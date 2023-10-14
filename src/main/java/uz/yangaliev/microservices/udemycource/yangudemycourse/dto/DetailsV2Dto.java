package uz.yangaliev.microservices.udemycource.yangudemycourse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailsV2Dto {
    private String email;

    private String phoneNumber;
}
