package api.attornatus.person.dto;




import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AddressDTO {

    private long id;
    private String street;
    private String zipCode;
    private String number;
    private String city;
    private boolean main;

}
