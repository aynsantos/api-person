package api.attornatus.person.controller;



import api.attornatus.person.dto.AddressDTO;
import api.attornatus.person.dto.PersonDTO;
import api.attornatus.person.mapper.AddressMapper;
import api.attornatus.person.mapper.PersonMapper;
import api.attornatus.person.model.Address;
import api.attornatus.person.model.Person;
import api.attornatus.person.controller.service.PersonService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {


    private PersonMapper personMapper;
    private PersonService personService;

    private AddressMapper addressMapper;

    @PostMapping
    @ApiOperation("Create person")
    public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO dto) {
        Person personCreate = personMapper.toPerson(dto);
        Person person = personService.create(personCreate);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping
    @ApiOperation("Find all persons")
    public ResponseEntity<List<PersonDTO>> findAll(){
        List<Person> personList = personService.findAll();
        List<PersonDTO> result = personMapper.ToPersonDTOList(personList);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{personId}")
    @ApiOperation("Delete Person")
    public ResponseEntity<Void> delete (@PathVariable Long personId) {
        Person person = personService.findPerson(personId);

        personService.delete(personId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{personId}")
    @ApiOperation("Find Person By Id")
    public ResponseEntity<PersonDTO> findById(@PathVariable Long personId) {
        Person person = personService.findPerson(personId);

        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{personId}")
    @ApiOperation("Update Person")
    public ResponseEntity<PersonDTO> updatePerson (@PathVariable Long personId, @RequestBody PersonDTO dto) {
        Person personUpdate = personMapper.toPerson(dto);
        Person person = personService.update(personId, personUpdate);
        PersonDTO result = personMapper.toPersonDTO(person);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{personId}")
    @ApiOperation("Create new address for a person")
    public ResponseEntity<PersonDTO> createNewAddress(@PathVariable Long personId, @RequestBody AddressDTO addressDTO) {
        Address addressCreate = addressMapper.toAddress(addressDTO);
        Person address = personService.addNewAddress(personId, addressCreate);
        PersonDTO result = personMapper.toPersonDTO(address);
        return ResponseEntity.status(HttpStatus.OK).body(result);

    }

    @GetMapping("/{personId}/address")
    @ApiOperation("Find all address by person")
    public ResponseEntity<List<Address>> findAllAddressByPerson(@PathVariable Long personId) {
        Person person = personService.findPerson(personId);
        List<Address> result = personService.findAddressByPerson(person);
        return ResponseEntity.ok(result);

    }













}
