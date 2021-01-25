package org.hino.sbb.service;

import org.hino.sbb.dao.TicketDAO;
import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TicketCreateDTO;
import org.hino.sbb.dto.TicketDTO;
import org.hino.sbb.mappers.TicketMapper;
import org.hino.sbb.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class TicketService {

    @Autowired
    private TicketDAO dao;
    @Autowired
    PassengerService passengerService;
    @Autowired
    TrainService trainService;

    @Autowired
    private TicketMapper mapper;

    public TicketService() {}

    @Transactional (readOnly = true)
    public List<Ticket> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public List<TicketDTO> findAllDTO() {
        List<TicketDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public Ticket findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public List<Ticket> findByTrain(long trainId)  {
        return dao.findByTrain(trainId);
    }

    @Transactional (readOnly = true)
    public List<TicketDTO> findDTOByTrain(long trainId)  {
        return mapper.toDto(findByTrain(trainId));
    }

    @Transactional (readOnly = true)
    public TicketDTO findDTObyId(long id) {
        return mapper.toDto(dao.findById(id));
    }

    public Ticket create(Ticket entity) {
        return dao.create(entity);
    }

    public Ticket create(PassengerDTO passengerDTO, long trainId) {
        Train train = trainService.findById(trainId);
        Passenger passenger = passengerService.findOrCreate(passengerDTO);
        Ticket entity = new Ticket(LocalDateTime.now(), train, passenger);
        return create(entity);
    }

    /*public Ticket create(Train train, Passenger passenger) {
        Ticket entity = new Ticket(LocalDateTime.now(), train, passenger);
        return create(entity);
    }*/

    /*public TicketDTO create(TicketCreateDTO ticketDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(ticketDTO.getTrainId());
        Passenger passenger = passengerService.findById(ticketDTO.getPassengerId());

        Ticket entity = new Ticket(LocalDateTime.now(), train, passenger);
        //------------------------------------------------------------------------------------------------

        return mapper.toDto(dao.create(entity));
    }*/

    public Ticket update(Ticket entity) {
        return dao.update(entity);
    }

    public TicketDTO update(TicketCreateDTO ticketDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(ticketDTO.getTrainId());
        Passenger passenger = passengerService.findById(ticketDTO.getPassengerId());
        Ticket entity = new Ticket(LocalDateTime.now(), train, passenger);
        //------------------------------------------------------------------------------------------------
        return mapper.toDto(dao.update(entity));
    }

    public Ticket delete(long id) {
        Ticket entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
