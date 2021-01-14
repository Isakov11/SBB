package org.hino.sbb.service;

import org.hino.sbb.dao.PassengerDAO;
import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.mappers.PassengerMapper;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class PassengerService {

    @Autowired
    private PassengerDAO dao;

    @Autowired
    private PassengerMapper mapper;

    public PassengerService() {}

    @Transactional (readOnly = true)
    public List<Passenger> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public List<PassengerDTO> findAllDTO() {
        List<PassengerDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public Passenger findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public PassengerDTO findDTOById(long id) {
        return mapper.toDto(dao.findById(id));
    }

    public Passenger create(Passenger entity) {
        return dao.create(entity);
    }

    public PassengerDTO create(PassengerDTO dto) {
        Passenger entity = mapper.toEntity(dto);
        entity.setTickets(new HashSet<>());
        return mapper.toDto(dao.create(entity));
    }

    public Passenger update(Passenger entity) {
        return dao.update(entity);
    }

    public PassengerDTO update(PassengerDTO dto) {
        Passenger entity = mapper.toEntity(dto);
        entity.setTickets(new HashSet<>());
        return mapper.toDto(dao.update(entity));
    }

    public Passenger delete(long id) {
        Passenger entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}