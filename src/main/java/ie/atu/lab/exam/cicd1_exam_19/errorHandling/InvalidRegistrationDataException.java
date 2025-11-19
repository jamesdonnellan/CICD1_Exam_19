package ie.atu.lab.exam.cicd1_exam_19.errorHandling;

public class InvalidRegistrationDataException extends RuntimeException {
    public InvalidRegistrationDataException(String message) {
        super(message);
    }
}
