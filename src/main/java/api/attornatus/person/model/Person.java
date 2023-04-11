package api.attornatus.person.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private Long id;
    private String name;
    private LocalDate birthDate;
    private List<Address> address = new ArrayList<>();


}
