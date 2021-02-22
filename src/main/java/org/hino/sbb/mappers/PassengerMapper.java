package org.hino.sbb.mappers;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.model.Passenger;
import org.mapstruct.Mapper;
import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PassengerMapper {
    Passenger toEntity (PassengerDTO dto);

    PassengerDTO toDto (Passenger entity);
    List<PassengerDTO> toDto (Collection<Passenger> entity);

}
