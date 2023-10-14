package uz.yangaliev.microservices.udemycource.yangudemycourse.mapper.interfaces;

import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.EmployeeDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;

public interface EmployeeDtoMapper {
    EmployeeDto getEmployeeDto(EmployeeEntity employee);
}
