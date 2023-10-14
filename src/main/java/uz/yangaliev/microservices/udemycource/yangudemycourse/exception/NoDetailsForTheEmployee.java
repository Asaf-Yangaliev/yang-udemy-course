package uz.yangaliev.microservices.udemycource.yangudemycourse.exception;

public class NoDetailsForTheEmployee extends RuntimeException {

    private String localizedMessage;

    public NoDetailsForTheEmployee(Long employeeId) {
        localizedMessage = "There are no details for Employee employeeId = %s".formatted(employeeId);
    }

    @Override
    public String getLocalizedMessage() {
        return localizedMessage;
    }
}
