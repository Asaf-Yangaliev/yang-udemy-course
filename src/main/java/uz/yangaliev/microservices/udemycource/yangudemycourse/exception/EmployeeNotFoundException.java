package uz.yangaliev.microservices.udemycource.yangudemycourse.exception;


public class EmployeeNotFoundException extends RuntimeException {

    private final String localizedMessage;

    public EmployeeNotFoundException(Long employeeId) {
        localizedMessage = "Employee with id = %s doesn't exist".formatted(employeeId);
    }

    @Override
    public String getLocalizedMessage() {
        return localizedMessage;
    }
}
