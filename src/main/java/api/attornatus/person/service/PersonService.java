package api.attornatus.person.service;

import api.attornatus.person.exception.BusinessException;
import api.attornatus.person.model.Address;
import api.attornatus.person.model.Person;
import api.attornatus.person.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public Person update(Long id, Person personUpdate) {
        Person person = findPerson(id);
        person.setName(personUpdate.getName());
        person.setBirthDate(personUpdate.getBirthDate());
        List<Address> addressesToUpdate = new ArrayList<>();

        for (Address address : personUpdate.getAddress()) {
            // Verifica se o endereço já existe na lista antiga e atualiza seus dados
            Address existingAddress = person.getAddress().stream()
                    .filter(a -> Objects.equals(a.getId(), address.getId()))
                    .findFirst()
                    .orElse(null);
            if (existingAddress != null) {
                existingAddress.setStreet(address.getStreet());
                existingAddress.setCity(address.getCity());
                existingAddress.setNumber(address.getNumber());
                existingAddress.setZipCode(address.getZipCode());
                addressesToUpdate.add(existingAddress);
            } else {
                // Adiciona um novo endereço que ainda não existe na lista antiga
                addressesToUpdate.add(address);
            }
        }

        // Remove os endereços antigos que não existem mais na lista nova
        List<Address> addressesToRemove = new ArrayList<>();
        for (Address address : person.getAddress()) {
            if (!addressesToUpdate.contains(address)) {
                addressesToRemove.add(address);
            }
        }
        person.getAddress().removeAll(addressesToRemove);

        // Adiciona os novos endereços ou atualiza os existentes
        person.getAddress().addAll(addressesToUpdate);

        personRepository.save(person);
        return person;

    }

}






