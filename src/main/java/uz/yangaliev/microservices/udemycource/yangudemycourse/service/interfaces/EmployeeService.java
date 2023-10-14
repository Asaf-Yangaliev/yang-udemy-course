package uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces;

import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.EmployeeDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();
    EmployeeEntity saveEmployee(EmployeeEntity employee);
    EmployeeDto findById(Long id);
}
