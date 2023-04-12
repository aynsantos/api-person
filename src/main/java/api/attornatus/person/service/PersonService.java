package api.attornatus.person.service;

import api.attornatus.person.model.Person;
import api.attornatus.person.repository.AddressRepository;
import api.attornatus.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private AddressRepository addressRepository;
    private ModelMapper modelMapper;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person create(Person personCreate) {
        return personRepository.save(personCreate);
    }



}
