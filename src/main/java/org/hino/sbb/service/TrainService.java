package org.hino.sbb.service;

import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.dao.TrainDAO;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainDAO dao;

    public TrainService() {

    }

    public List<Train> findAll() {
        return dao.findAll();
    }

    public Train findById(long id) {
        return dao.findById(id);
    }

    public Train create(Train train) {
        return dao.create(train);
    }

    public Train update(Train train) {
        return dao.update(train);
    }

    public Train delete(long id) {
        Train train = dao.findById(id);
        return dao.delete(train);
    }
}
