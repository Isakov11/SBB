package org.hino.sbb.dao;

import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ScheduleNodeDAO {
    @Autowired
    StationDAO stationDAO;

    @Autowired
    TrainDAO trainDAO;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional (readOnly = true)
    public List<ScheduleNode> findAll(){
        return entityManager.createNamedQuery(ScheduleNode.FIND_ALL,ScheduleNode.class).getResultList();
    }

    @Transactional (readOnly = true)
    public ScheduleNode findById(long id)  {
        return entityManager.find(ScheduleNode.class, id);
    }

    @Transactional
    public ScheduleNode create(ScheduleNode entity){

        //---------------------------------------

        Station station = stationDAO.findById(entity.getStation().getId());
        entityManager.merge(station);
        entity.setStation(station);

        Train train = trainDAO.findById(entity.getTrain().getId());
        entityManager.merge(train);
        entity.setTrain(train);
        //---------------------------------------
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public ScheduleNode update(ScheduleNode entity){
        entityManager.merge(entity);
        return entity;
    }

    @Transactional
    public ScheduleNode delete(ScheduleNode entity){
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }
}
