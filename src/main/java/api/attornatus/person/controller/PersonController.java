package api.attornatus.person.controller;


import api.attornatus.person.model.Person;
import api.attornatus.person.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    private PersonRepository personRepository;

    @PostMapping
    public Person created(@RequestBody Person person){
        return personRepository.save(person);
    }


}
