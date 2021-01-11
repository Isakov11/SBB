package org.hino.sbb.service;

import org.hino.sbb.dao.PassengerDAO;
import org.hino.sbb.model.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PassengerService {

    @Autowired
    private PassengerDAO dao;

    public PassengerService() {}

    @Transactional (readOnly = true)
    public List<Passenger> findAll() {
        return dao.findAll();
    }

    @Transactional (readOnly = true)
    public Passenger findById(long id) {
        return dao.findById(id);
    }

    public Passenger create(Passenger entity) {
        return dao.create(entity);
    }

    public Passenger update(Passenger entity) {
        return dao.update(entity);
    }

    public Passenger delete(long id) {
        Passenger entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
