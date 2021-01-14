package org.hino.sbb.service;

import org.hino.sbb.dao.ScheduleNodeDAO;
import org.hino.sbb.dto.ScheduleCreateDTO;
import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.mappers.ScheduleNodeMapper;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class SchedulesService {

    @Autowired
    private ScheduleNodeDAO dao;
    @Autowired
    StationService stationService;
    @Autowired
    TrainService trainService;

    @Autowired
    private ScheduleNodeMapper mapper;

    public SchedulesService() {}

    @Transactional (readOnly = true)
    public List<ScheduleNode> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public Set<ScheduleNodeDTO> findAllDTO() {
        Set<ScheduleNodeDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public ScheduleNode findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public ScheduleNodeDTO findDTObyId(long id) {
        return mapper.toDto(dao.findById(id));
    }

    public ScheduleNode create(ScheduleNode entity) {
        return dao.create(entity);
    }

    public ScheduleNodeDTO create(ScheduleCreateDTO scheduleCreateDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(scheduleCreateDTO.getTrainId());
        Station station = stationService.findById(scheduleCreateDTO.getStationId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime arrivalTime = null;
        LocalDateTime departureTime = null;
        if (scheduleCreateDTO.getArrivalTime() != null && !scheduleCreateDTO.getArrivalTime().equals(""))        {
            arrivalTime = LocalDateTime.parse(scheduleCreateDTO.getArrivalTime(),formatter);
        }
        if (scheduleCreateDTO.getDepartureTime() !=null && !scheduleCreateDTO.getDepartureTime().equals(""))        {
            departureTime = LocalDateTime.parse(scheduleCreateDTO.getDepartureTime(),formatter);
        }
        ScheduleNode entity = new ScheduleNode(0,train,scheduleCreateDTO.getStationOrder(),station,arrivalTime,departureTime);
        //------------------------------------------------------------------------------------------------

        return mapper.toDto(dao.create(entity));
    }

    public ScheduleNode update(ScheduleNode entity) {
        return dao.update(entity);
    }

    public ScheduleNodeDTO update(ScheduleCreateDTO scheduleCreateDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(scheduleCreateDTO.getTrainId());
        Station station = stationService.findById(scheduleCreateDTO.getStationId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime arrivalTime = null;
        LocalDateTime departureTime = null;
        if (scheduleCreateDTO.getArrivalTime() != null && !scheduleCreateDTO.getArrivalTime().equals(""))        {
            arrivalTime = LocalDateTime.parse(scheduleCreateDTO.getArrivalTime(),formatter);
        }
        if (scheduleCreateDTO.getDepartureTime() !=null && !scheduleCreateDTO.getDepartureTime().equals(""))        {
            departureTime = LocalDateTime.parse(scheduleCreateDTO.getDepartureTime(),formatter);
        }
        ScheduleNode entity = new ScheduleNode(0,train,scheduleCreateDTO.getStationOrder(),station,arrivalTime,departureTime);
        //------------------------------------------------------------------------------------------------
        return mapper.toDto(dao.update(entity));
    }

    public ScheduleNode delete(long id) {
        ScheduleNode entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
