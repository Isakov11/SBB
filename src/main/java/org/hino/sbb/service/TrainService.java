package org.hino.sbb.service;

import org.hino.sbb.dao.TrainDAO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.mappers.TrainMapper;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class TrainService {

    @Autowired
    private TrainDAO dao;

    @Autowired
    private TrainMapper mapper;

    public TrainService() { }

    @Transactional (readOnly = true)
    public List<Train> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public List<TrainDTO> findAllDTO() {
        List<TrainDTO> dtoList = mapper.toDto(dao.findAll());
        return dtoList;
    }

    @Transactional (readOnly = true)
    public Train findById(long id) {
        return dao.findById(id);
    }

    @Transactional (readOnly = true)
    public TrainDTO findDTObyId(long id) {
        return mapper.toDto(dao.findById(id));
    }

    public Train create(Train train) {
        return dao.create(train);
    }

    public TrainDTO create(TrainDTO dto) {
        Train entity = mapper.toEntity(dto);
        entity.setTrainSchedule(new LinkedList<>());
        return mapper.toDto(dao.create(entity));
    }

    public Train update(Train train) {
        return dao.update(train);
    }

    public TrainDTO update(TrainDTO dto) {
        Train entity = mapper.toEntity(dto);
        entity.setTrainSchedule(new LinkedList<>());
        return mapper.toDto(dao.update(entity));
    }

    public Train delete(long id) {
        Train train = dao.findById(id);
        return dao.delete(train);
    }

    public TrainDTO deleteRetDTO(long id) {
        Train train = dao.findById(id);
        return mapper.toDto(dao.delete(train));
    }
}
