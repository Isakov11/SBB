package org.hino.sbb.service;

import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.dao.TrainDAO;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrainService {

    @Autowired
    private TrainDAO dao;

    public TrainService() {

    }
    @Transactional
    public List<Train> findAll() {
        return dao.findAll();
    }
    @Transactional
    public Train findById(long id) {
        return dao.findById(id);
    }
    @Transactional
    public Train create(Train train) {
        return dao.create(train);
    }
    @Transactional
    public Train update(Train train) {
        return dao.update(train);
    }
    @Transactional
    public Train delete(long id) {
        Train train = dao.findById(id);
        return dao.delete(train);
    }
}
