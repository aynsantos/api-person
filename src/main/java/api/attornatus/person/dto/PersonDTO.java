package api.attornatus.person.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PersonDTO {

    private Long id;
    @Valid
    @NotBlank
    private String name;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past
    @NotNull
    private LocalDate birthDate;
    @Valid
    @NotEmpty
    private List<AddressDTO> address = new ArrayList<>();
}
