package uz.yangaliev.microservices.udemycource.yangudemycourse.service.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.DetailsDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeDetailsEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.EmployeeNotFoundException;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.NoDetailsForTheEmployee;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeDetailsRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeEntityRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces.EmployeeDetailsService;

@RequiredArgsConstructor
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

    private final EmployeeDetailsRepository detailsRepository;
    private final EmployeeEntityRepository employeeRepository;

    @Override
    public DetailsDto findByEmployeeId(Long employeeId) {
        EmployeeEntity employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        EmployeeDetailsEntity details = employee.getDetails();
        if (employee.getDetails() != null) {
            return DetailsDto.builder()
                    .employeeId(employeeId)
                    .email(details.getEmail())
                    .phoneNumber(details.getPhoneNumber())
                    .fullName("%s %s".formatted(details.getEmployee().getName(), details.getEmployee().getSurname()))
                    .build();
        }
        throw new NoDetailsForTheEmployee(employeeId);
    }

    @Override
    @Transactional
    public void saveEmployeeDetails(Long employeeId, EmployeeDetailsEntity details) {
        EmployeeEntity employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        details.setEmployee(employee);
        employee.setDetails(details);
        detailsRepository.save(details);
    }
}
