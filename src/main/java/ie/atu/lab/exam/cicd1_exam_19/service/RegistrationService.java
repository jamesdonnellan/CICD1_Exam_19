package ie.atu.lab.exam.cicd1_exam_19.service;

import ie.atu.lab.exam.cicd1_exam_19.model.EventRegistration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService
{
    private final List<EventRegistration> store = new ArrayList<>();

    public List<EventRegistration> findAll()
    {
        return new  ArrayList<>(store);
    }
    public Optional<EventRegistration> findById(String id)
    {
        for (EventRegistration p : store)
        {
           if (p.getPersonId().equals(id))
           {
               return Optional.of(p);
           }
        }
        return Optional.empty();
    }
}
