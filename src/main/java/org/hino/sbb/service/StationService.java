package org.hino.sbb.service;

import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StationService {

    @Autowired
    private StationDAO dao;

    public StationService() {
    }
    @Transactional
    public List<Station> findAll() {
        return dao.findAll();
    }
    @Transactional
    public Station findById(long id) {
        return dao.findById(id);
    }
    @Transactional
    public Station create(Station station) {
        return dao.create(station);
    }
    @Transactional
    public Station update(Station station) {
        return dao.update(station);
    }
    @Transactional
    public Station delete(long id) {
        Station station = dao.findById(id);
        if (station == null){
            return null;
        }
        return dao.delete(station);
    }
}
