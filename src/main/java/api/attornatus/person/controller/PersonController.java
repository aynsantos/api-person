package api.attornatus.person.controller;



import api.attornatus.person.dto.PersonDTO;
import api.attornatus.person.mapper.PersonMapper;
import api.attornatus.person.model.Person;
import api.attornatus.person.service.PersonService;
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












}
