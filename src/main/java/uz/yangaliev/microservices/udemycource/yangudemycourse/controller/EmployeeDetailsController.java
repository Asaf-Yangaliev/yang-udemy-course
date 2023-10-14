package uz.yangaliev.microservices.udemycource.yangudemycourse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import uz.yangaliev.microservices.udemycource.yangudemycourse.dto.DetailsDto;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeDetailsEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.service.interfaces.EmployeeDetailsService;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class EmployeeDetailsController {

    private final EmployeeDetailsService detailsService;

    @GetMapping("/employees/{id}/details")
    public DetailsDto findByEmployeeId(@PathVariable("id") Long employeeId) {
        return detailsService.findByEmployeeId(employeeId);
    }

    @PostMapping("/employees/{id}/details")
    public ResponseEntity<Object> save(@PathVariable("id") Long employeeId, @RequestBody EmployeeDetailsEntity details) {
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .build()
                .toUri();
        detailsService.saveEmployeeDetails(employeeId, details);
        return ResponseEntity.created(location).build();
    }
}
