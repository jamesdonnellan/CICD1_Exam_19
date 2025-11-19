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

    // Read
    public List<EventRegistration> findAll()
    {
        return new  ArrayList<>(store);
    }
    public Optional<EventRegistration> findById(String id)
    {
        for (EventRegistration p : store)
        {
           if (p.getTicketCode().equals(id))
           {
               return Optional.of(p);
           }
        }
        return Optional.empty();
    }

    // Create
    public EventRegistration create(EventRegistration p)
    {
        for (EventRegistration p1 : store)
        {
            if(findById(p.getTicketCode()).isPresent())
            {
                throw new DuplicateTicketCodeException ("Person with id: " + p.getTicketCode() + "already exists.");
            }
        }
        store.add(p);
        return p;
    }

    // Update
    public Optional <EventRegistration> update(String ticketCode, EventRegistration updated)
    {
        for(EventRegistration p : store)
        {
            if (p.getTicketCode().equals(ticketCode))
            {
                p.setAttendeeName(updated.getAttendeeName());
                p.setEmail(updated.getEmail());
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    // Delete
    public boolean delete(String ticketCode)
    {
        return store.removeIf(p -> p.getTicketCode().equals(ticketCode));
    }
}
