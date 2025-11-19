package ie.atu.lab.exam.cicd1_exam_19.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDetails
{
    private String fieldName;
    private String fieldValue;
}
