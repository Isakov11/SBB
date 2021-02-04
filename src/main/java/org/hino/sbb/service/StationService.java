package org.hino.sbb.service;

import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.mappers.StationMapper;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class StationService {

    @Autowired
    private StationDAO dao;

    @Autowired
    private StationMapper mapper;

    public StationService() {}

    @Transactional (readOnly = true)
    public List<Station> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public List<StationDTO> findAllDTO() {
        List<StationDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public Station findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public StationDTO findDTObyId(long id) {
        return mapper.toDto(findById(id));
    }

    public Station create(Station station) {
        return dao.create(station);
    }

    public StationDTO create(StationDTO dto) {
        Station entity = mapper.toEntity(dto);
        entity.setStationSchedule(new LinkedList<>());
        return mapper.toDto(dao.create(entity));
    }

    public Station update(Station station) {
        return dao.update(station);
    }

    public StationDTO update(StationDTO dto) {
        Station entity = mapper.toEntity(dto);
        entity.setStationSchedule(new LinkedList<>());
        return mapper.toDto(dao.update(entity));
    }

    public Station delete(long id) {
        Station entity = findById(id);
        if (entity == null){
            return null;
        }
        List<ScheduleNode> stationSchedule = entity.getStationSchedule();
        if (stationSchedule == null || stationSchedule.isEmpty()){
            return dao.delete(entity);
        }
        return null;
    }

    public StationDTO deleteRetDTO(long id) {
        Station entity = findById(id);
        if (entity == null){
            return null;
        }
        return mapper.toDto(delete(id));
    }
}
