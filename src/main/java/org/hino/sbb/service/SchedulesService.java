package org.hino.sbb.service;

import org.hino.sbb.dao.ScheduleNodeDAO;
import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.dto.StationDTO;
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

    public ScheduleNode create(long trainId,long stationOrder,long stationId,
                               String arrivalTimeString, String departureTimeString) {
        //-----------------------------------------------------------------------------------------------
        Train train = trainService.findById(trainId);
        Station station = stationService.findById(stationId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        LocalDateTime arrivalTime = null;
        LocalDateTime departureTime = null;
        if (arrivalTimeString !=null && !arrivalTimeString.equals(""))        {
            arrivalTime = LocalDateTime.parse(arrivalTimeString,formatter);
        }
        if (departureTimeString !=null && !departureTimeString.equals(""))        {
            departureTime = LocalDateTime.parse(departureTimeString,formatter);
        }
        ScheduleNode entity = new ScheduleNode(0,train,stationOrder,station,arrivalTime,departureTime);
        //------------------------------------------------------------------------------------------------

        return dao.create(entity);
    }

    public ScheduleNode update(ScheduleNode entity) {
        return dao.update(entity);
    }

    public ScheduleNodeDTO update(ScheduleNodeDTO dto) {
        return mapper.toDto(dao.update(mapper.toEntity(dto)));
    }

    public ScheduleNode delete(long id) {
        ScheduleNode entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
