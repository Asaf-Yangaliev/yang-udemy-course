package uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces;

import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.DetailsDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeDetailsEntity;

public interface EmployeeDetailsService {
    DetailsDto findByEmployeeId(Long employeeId);

    void saveEmployeeDetails(Long employeeId, EmployeeDetailsEntity details);
}
