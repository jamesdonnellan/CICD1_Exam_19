package ie.atu.lab.exam.cicd1_exam_19.errorHandling;

public class RegistrationNotFoundException extends RuntimeException {
    public RegistrationNotFoundException(String message) {
        super(message);
    }
}
