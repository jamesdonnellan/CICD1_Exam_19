package ie.atu.lab.exam.cicd1_exam_19.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalErrorHandling
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDetails>> showErrorDetails(MethodArgumentNotValidException mae)
    {
        List<ExceptionDetails> errorList = new ArrayList<>();
        for (FieldError fieldError : mae.getBindingResult().getFieldErrors())
        {
            ExceptionDetails exceptionDetails = new ExceptionDetails();
            exceptionDetails.setFieldName(fieldError.getField());
            exceptionDetails.setFieldValue(fieldError.getDefaultMessage());
            errorList.add(ExceptionDetails);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
    }

    @ExceptionHandler(DuplicateTicketCodeException.class)
    public ResponseEntity<DuplicateTicketCodeException> showDupError(DuplicateTicketCodeException dte)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(dte);
    }


    @ExceptionHandler(InvalidRegistrationDataException.class)
    public ResponseEntity<InvalidRegistrationDataException> showInvalidRegistrationData(InvalidRegistrationDataException ire)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ire);
    }

    @ExceptionHandler(RegistrationNotFoundException.class)
    public ResponseEntity<RegistrationNotFoundException> showRegistrationNotFound(RegistrationNotFoundException rnf)
    {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(rnf);
    }

}
