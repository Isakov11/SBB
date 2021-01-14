package org.hino.sbb.mappers;

import org.hino.sbb.dto.TicketDTO;
import org.hino.sbb.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;


@Mapper(componentModel = "spring")
public interface TicketMapper {

    @Mappings({
            @Mapping(source = "ticketTrain.number", target = "trainNumber"),
            @Mapping(source = "passenger.name", target = "passengerName"),
            @Mapping(source = "passenger.secondName", target = "passengerSecondName"),

    })
    TicketDTO toDto (Ticket entity);
    List<TicketDTO> toDto (Collection<Ticket> entity);
}
