package uz.yangaliev.microservices.udemycource.yangudemycourse.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.EmployeeDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeDetailsEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.EmployeeNotFoundException;
import uz.yangaliev.microservices.udemycource.yangudemycourse.mapper.interfaces.EmployeeDtoMapper;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeDetailsRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeEntityRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces.EmployeeService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeEntityRepository employeeRepository;
    private final EmployeeDetailsRepository detailsRepository;
    private final EmployeeDtoMapper employeeDtoMapper;


    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employeeDtoMapper::getEmployeeDto)
                .toList();
    }

    @Override
    @Transactional
    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        if (employee.getDetails() != null) {
            EmployeeDetailsEntity saved = detailsRepository.save(employee.getDetails());
            employee.setDetails(saved);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public EmployeeDto findById(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        return employeeDtoMapper.getEmployeeDto(employee);
    }
}
