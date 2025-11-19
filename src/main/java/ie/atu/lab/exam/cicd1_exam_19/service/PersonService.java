package ie.atu.lab.exam.cicd1_exam_19.service;

import ie.atu.lab.exam.cicd1_exam_19.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.util.ClassUtils.isPresent;

@Service
public class PersonService
{
    private final List<Person> store = new ArrayList<>();

    public List<Person> findAll()
    {
        return new  ArrayList<>(store);
    }
    public Optional<Person> findById(String id)
    {
        for (Person p : store)
        {
           if (p.getPersonId().equals(id))
           {
               return Optional.of(p);
           }
        }
        return Optional.empty();
    }
}
