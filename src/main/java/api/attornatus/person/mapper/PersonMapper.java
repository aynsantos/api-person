package api.attornatus.person.mapper;


import api.attornatus.person.dto.PersonDTO;
import api.attornatus.person.model.Person;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class PersonMapper {

    private ModelMapper modelMapper;

    public PersonDTO toPersonDTO (Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    public List<PersonDTO> ToPersonDTOList (List<Person> personList) {
        return personList.stream()
                .map(this::toPersonDTO)
                .collect(Collectors.toList());
    }

    public Person toPerson(PersonDTO dto) {
        return modelMapper.map(dto, Person.class);
    }


}
