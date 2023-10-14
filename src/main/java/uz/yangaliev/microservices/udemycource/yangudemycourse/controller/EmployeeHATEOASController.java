package uz.yangaliev.microservices.udemycource.yangudemycourse.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.EmployeeNotFoundException;
import uz.yangaliev.microservices.udemycource.yangudemycourse.repository.EmployeeEntityRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hateoas")
public class EmployeeHATEOASController {

    private final EmployeeEntityRepository employeeRepository;

    @GetMapping("/employees/{id}")
    public EntityModel<EmployeeEntity> findById(@PathVariable("id") Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        EntityModel<EmployeeEntity> entityModel = EntityModel.of(employee);
        WebMvcLinkBuilder link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder
                        .methodOn(EmployeeController.class).findAll());
        entityModel.add(link.withRel("get-all-users"));
        return entityModel;
    }
}
