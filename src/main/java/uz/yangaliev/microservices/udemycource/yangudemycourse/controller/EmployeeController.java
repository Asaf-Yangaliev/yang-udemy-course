package uz.yangaliev.microservices.udemycource.yangudemycourse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.EmployeeDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeEntityRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces.EmployeeService;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    private final EmployeeEntityRepository employeeRepository;

    @GetMapping("/employees")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public EmployeeDto findById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeEntity> saveEmployee(@RequestBody EmployeeEntity employee) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
    }
}
