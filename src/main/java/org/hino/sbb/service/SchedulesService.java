package org.hino.sbb.service;

import org.hino.sbb.dao.ScheduleNodeDAO;
import org.hino.sbb.dao.StationDAO;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulesService {

    @Autowired
    private ScheduleNodeDAO dao;

    public SchedulesService() {
    }

    public List<ScheduleNode> findAll() {
        return dao.findAll();
    }

    public ScheduleNode findById(long id) {
        return dao.findById(id);
    }

    public ScheduleNode create(ScheduleNode entity) {
        return dao.create(entity);
    }

    public ScheduleNode update(ScheduleNode entity) {
        return dao.update(entity);
    }

    public ScheduleNode delete(long id) {
        ScheduleNode entity = dao.findById(id);
        if (entity == null){
            return null;
        }
        return dao.delete(entity);
    }
}
