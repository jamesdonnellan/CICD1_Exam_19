package ie.atu.lab.exam.cicd1_exam_19.controller;

import ie.atu.lab.exam.cicd1_exam_19.model.EventRegistration;
import ie.atu.lab.exam.cicd1_exam_19.service.RegistrationService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController@RequestMapping("/api/Person")
public class RegistrationController
{
    private final RegistrationService service;
    public RegistrationController(RegistrationService service)
    {
        this.service = service;
    }

    // Create
    @PostMapping("/registrations")
    public ResponseEntity<EventRegistration> create(@Valid @RequestBody EventRegistration p)
    {
        EventRegistration created = service.create(p);
        return ResponseEntity
                .created(URI.create("/api/Person/registrations"))
                .body(created);
    }

    // Read
    @GetMapping("/registrations/{ticketCode}")
    public ResponseEntity<EventRegistration> getOne (@PathVariable String ticketCode)
    {
        Optional<EventRegistration> maybe = service.findById(ticketCode);
        if (maybe.isPresent())
        {
            return ResponseEntity.ok(maybe.get());

        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<EventRegistration>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }


    // Update
    @PutMapping("/registrations/{ticketCode}")
    public ResponseEntity<EventRegistration> update(@PathVariable String ticketCode, @Valid @RequestBody EventRegistration updated)
    {
        Optional<EventRegistration> maybe = service.update(ticketCode, updated);
        return maybe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Delete
    @DeleteMapping("/registrations/{ticketCode}")
    public ResponseEntity <EventRegistration> delete(@PathVariable String ticketCode)
    {
        boolean removed = service.delete(ticketCode);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
