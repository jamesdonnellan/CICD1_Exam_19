package ie.atu.lab.exam.cicd1_exam_19.errorHandling;

public class DuplicateTicketCodeException extends RuntimeException
{
    public DuplicateTicketCodeException(String message)
    {
        super(message = "[ERROR] Duplicate Ticket Code.");
    }
}
