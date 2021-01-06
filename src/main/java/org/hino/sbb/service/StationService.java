package org.hino.sbb.service;

import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService {

    @Autowired
    private StationDAO dao;

    public StationService() {
    }

    public List<Station> findAll() {
        return dao.findAll();
    }

    public Station findById(long id) {
        return dao.findById(id);
    }

    public Station create(Station station) {
        return dao.create(station);
    }

    public Station update(Station station) {
        return dao.update(station);
    }

    public Station delete(long id) {
        Station station = dao.findById(id);
        if (station == null){
            return null;
        }
        return dao.delete(station);
    }
}
