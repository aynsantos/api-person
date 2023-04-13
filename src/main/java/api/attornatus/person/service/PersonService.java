package api.attornatus.person.service;

import api.attornatus.person.exception.BusinessException;
import api.attornatus.person.model.Person;
import api.attornatus.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;


    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person personCreate) {
        return personRepository.save(personCreate);
    }

    public void delete(Long personId) {
        personRepository.deleteById(personId);
    }

    public Person findPerson (Long personId) {
        return personRepository.findById(personId)
                .orElseThrow(()-> new BusinessException("Pessoa não encontrada"));
    }





}
