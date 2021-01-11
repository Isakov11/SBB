package org.hino.sbb.mappers;

import org.hino.sbb.dto.TicketDTO;
import org.hino.sbb.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TicketMapper implements InterfaceMapper<TicketDTO, Ticket> {
    //TODO   TicketMapper
    @Override
    public Ticket toEntity(TicketDTO dto) {
        return null;
    }

    @Override
    public TicketDTO toDto(Ticket entity) {
        return null;
    }

    @Override
    public Collection<TicketDTO> toDto(Collection<Ticket> collection) {
        return null;
    }
}
