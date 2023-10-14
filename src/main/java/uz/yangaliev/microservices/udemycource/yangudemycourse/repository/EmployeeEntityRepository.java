package uz.yangaliev.microservices.udemycource.yangudemycourse.repository;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {


    @EntityGraph(value = "employee_details")
    @Override
    List<EmployeeEntity> findAll();

    @EntityGraph(value = "employee_details")
    Optional<EmployeeEntity> findById(@NotNull Long id);
}
