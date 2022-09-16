package br.com.example.sistemabancario2.personController;

import br.com.example.sistemabancario2.error.ResourceNotFoundException;
import br.com.example.sistemabancario2.model.Person;
import br.com.example.sistemabancario2.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/person")
public class PersonController {
    private PersonRepository personDAO;

    @Autowired
    public PersonController(PersonRepository personDAO){
        this.personDAO = personDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(Pageable pageable){
        return new ResponseEntity<>(personDAO.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        verifyIfPersonExists(id);
        Person person = personDAO.findById(id).get();
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody Person person){
        return new ResponseEntity<>(personDAO.save(person),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        verifyIfPersonExists(id);
        personDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Person person){
        verifyIfPersonExists(person.getId());
        personDAO.save(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void verifyIfPersonExists(Long id){
        if(!personDAO.findById(id).isPresent()){
            throw new ResourceNotFoundException("Person not found for ID: "+id);
        }
    }

}
