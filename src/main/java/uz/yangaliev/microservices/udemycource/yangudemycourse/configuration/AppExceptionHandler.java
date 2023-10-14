package uz.yangaliev.microservices.udemycource.yangudemycourse.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.EmployeeNotFoundException;
import uz.yangaliev.microservices.udemycource.yangudemycourse.exception.NoDetailsForTheEmployee;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorBody> handleEmployeeNotFoundException(EmployeeNotFoundException e) {
        ErrorBody errorBody = ErrorBody.builder()
                .localizedMessage(e.getLocalizedMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
    }

    @ExceptionHandler(NoDetailsForTheEmployee.class)
    public ResponseEntity<ErrorBody> handleEmployeeNotFoundException(NoDetailsForTheEmployee e) {
        ErrorBody errorBody = ErrorBody.builder()
                .localizedMessage(e.getLocalizedMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorBody);
    }
}
