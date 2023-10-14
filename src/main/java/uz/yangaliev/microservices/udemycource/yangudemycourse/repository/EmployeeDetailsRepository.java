package uz.yangaliev.microservices.udemycource.yangudemycourse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.yangaliev.microservices.udemycource.yangudemycourse.entity.EmployeeDetailsEntity;

import java.util.Optional;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetailsEntity, Long> {
    Optional<EmployeeDetailsEntity> findByEmployee_Id(Long employeeId);
}
