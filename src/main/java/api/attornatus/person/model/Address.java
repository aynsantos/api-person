package api.attornatus.person.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private long id;
    private String street;
    private String zipCode;
    private String city;
    private boolean main;


}
