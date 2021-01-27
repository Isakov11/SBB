package org.hino.sbb.mappers;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.Train;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface PassengerMapper {
    //@Mapping(source ="birthDate", dateFormat = "dd.MM.yyyy",target = "birthDate")
    Passenger toEntity (PassengerDTO dto);

    //@Mapping(source ="birthDate", dateFormat = "dd.MM.yyyy",target = "birthDate")
    PassengerDTO toDto (Passenger entity);
    List<PassengerDTO> toDto (Collection<Passenger> entity);

}
