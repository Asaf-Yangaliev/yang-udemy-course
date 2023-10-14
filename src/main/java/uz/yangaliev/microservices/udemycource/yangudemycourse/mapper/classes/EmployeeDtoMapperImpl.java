package uz.yangaliev.microservices.udemycource.yangudemycourse.mapper.classes;

import org.springframework.stereotype.Service;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.DetailsV2Dto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.EmployeeDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.mapper.interfaces.EmployeeDtoMapper;

@Service
public class EmployeeDtoMapperImpl implements EmployeeDtoMapper {
    @Override
    public EmployeeDto getEmployeeDto(EmployeeEntity employee) {
        DetailsV2Dto details = employee.getDetails() == null ? null : DetailsV2Dto.builder()
                .email(employee.getDetails().getEmail())
                .phoneNumber(employee.getDetails().getPhoneNumber())
                .build();
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .surname(employee.getSurname())
                .birthday(employee.getBirthday())
                .details(details)
                .build();
    }
}
