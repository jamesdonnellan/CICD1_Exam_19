package ie.atu.lab.exam.cicd1_exam_19.controller;

import ie.atu.lab.exam.cicd1_exam_19.model.Person;
import ie.atu.lab.exam.cicd1_exam_19.service.PersonService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController@RequestMapping("/api/Person")
public class PersonController
{
    private final PersonService service;
    public PersonController(PersonService service)
    {
        this.service = service;
    }

    // Create
    @PostMapping("/registrations")
    public ResponseEntity<Person> create(@Valid @RequestBody Person p)
    {
        Person created = service.create(p);
        return ResponseEntity
                .created(URI.create("/api/Person/registrations"))
                .body(created);
    }

    // Read
    @GetMapping("/registrations/{ticketCode}")
    public ResponseEntity<Person> getOne (@PathVariable String ticketCode)
    {
        Optional<Person> maybe = service.findById(ticketCode);
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
    public ResponseEntity<List<Person>> findAll()
    {
        return ResponseEntity.ok(service.findAll());
    }


    // Update
    @PutMapping("/registrations/{ticketCode}")
    public ResponseEntity<Person> update(@PathVariable String ticketCode, @Valid @RequestBody Person updated)
    {
        Optional<Person> maybe = service.update(ticketCode, updated);
        return maybe.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    // Delete
    @DeleteMapping("/registrations/{ticketCode}")
    public ResponseEntity <Person> delete(@PathVariable String ticketCode)
    {
        boolean removed = service.delete(ticketCode);
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
