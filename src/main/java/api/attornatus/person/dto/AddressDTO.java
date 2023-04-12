package api.attornatus.person.dto;




import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class AddressDTO {

    private long id;
    @NotBlank
    private String street;
    @NotBlank
    private String zipCode;
    @NotBlank
    private String number;
    @NotBlank
    private String city;
    private boolean main;

}
