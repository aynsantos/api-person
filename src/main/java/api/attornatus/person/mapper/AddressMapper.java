package api.attornatus.person.mapper;

import api.attornatus.person.dto.AddressDTO;
import api.attornatus.person.model.Address;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class AddressMapper {

    private ModelMapper modelMapper;

    public AddressDTO toAddressDTO (Address address) {
        return modelMapper.map(address, AddressDTO.class);
    }





}
