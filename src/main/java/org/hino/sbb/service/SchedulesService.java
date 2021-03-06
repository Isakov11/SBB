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
import java.util.stream.Collectors;

@Service
@Transactional
public class SchedulesService {

    private ScheduleNodeDAO dao;

    private StationService stationService;

    private TrainService trainService;

    private ScheduleNodeMapper mapper;

    public SchedulesService() {
    }

    @Autowired
    public SchedulesService(ScheduleNodeDAO dao, StationService stationService,
                            TrainService trainService, ScheduleNodeMapper mapper) {
        this.dao = dao;
        this.stationService = stationService;
        this.trainService = trainService;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<ScheduleNode> findAll() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public List<ScheduleNodeDTO> findAllDTO() {
        List<ScheduleNodeDTO> dtoList = mapper.toDto(dao.findAll()).stream().
                sorted((o1, o2) -> (o1.getTrain().getNumber().compareTo(o2.getTrain().getNumber()) )).
                collect(Collectors.toList());
        return dtoList;
    }

    @Transactional(readOnly = true)
    public ScheduleNode findById(long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    public ScheduleNodeDTO findDTObyId(long id) {
        return mapper.toDto(dao.findById(id));
    }

    public ScheduleNode create(ScheduleNode entity) {
        ScheduleNode node = dao.create(entity);

        return node;
    }

    public ScheduleNodeDTO create(ScheduleCreateDTO scheduleCreateDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(scheduleCreateDTO.getTrainId());
        Station station = stationService.findById(scheduleCreateDTO.getStationId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime arrivalTime = null;
        LocalDateTime departureTime = null;
        if (scheduleCreateDTO.getArrivalTime() != null && !scheduleCreateDTO.getArrivalTime().equals("")) {
            arrivalTime = LocalDateTime.parse(scheduleCreateDTO.getArrivalTime(), formatter);

        }
        else{
            arrivalTime = LocalDateTime.parse("01.01.1753 00:00", formatter);
        }
        if (scheduleCreateDTO.getDepartureTime() != null && !scheduleCreateDTO.getDepartureTime().equals("")) {
            departureTime = LocalDateTime.parse(scheduleCreateDTO.getDepartureTime(), formatter);
        }
        else{
            departureTime = LocalDateTime.parse("01.01.9999 00:00", formatter);
        }
        ScheduleNode entity = new ScheduleNode(0, train, station, arrivalTime, departureTime);
        //------------------------------------------------------------------------------------------------

        return mapper.toDto(create(entity));
    }

    public ScheduleNode update(ScheduleNode entity) {
        ScheduleNode node = dao.update(entity);
        return node;
    }

    public ScheduleNodeDTO update(ScheduleCreateDTO scheduleCreateDTO) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(scheduleCreateDTO.getTrainId());
        Station station = stationService.findById(scheduleCreateDTO.getStationId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime arrivalTime = null;
        LocalDateTime departureTime = null;
        if (scheduleCreateDTO.getArrivalTime() != null && !scheduleCreateDTO.getArrivalTime().equals("")) {
            arrivalTime = LocalDateTime.parse(scheduleCreateDTO.getArrivalTime(), formatter);
        }
        else{
            arrivalTime = LocalDateTime.parse("01.01.1753 00:00", formatter);
        }
        if (scheduleCreateDTO.getDepartureTime() != null && !scheduleCreateDTO.getDepartureTime().equals("")) {
            departureTime = LocalDateTime.parse(scheduleCreateDTO.getDepartureTime(), formatter);
        }
        else{
            departureTime = LocalDateTime.parse("01.01.9999 00:00", formatter);
        }
        ScheduleNode entity = new ScheduleNode(scheduleCreateDTO.getId(), train, station, arrivalTime, departureTime);
        //------------------------------------------------------------------------------------------------
        return mapper.toDto(update(entity));
    }

    public ScheduleNode delete(long id) {
        ScheduleNode entity = dao.findById(id);
        if (entity == null) {
            return null;
        }
        ScheduleNode node =dao.delete(entity);
        return node;
    }
}
