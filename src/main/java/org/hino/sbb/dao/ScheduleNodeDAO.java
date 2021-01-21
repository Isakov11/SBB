package org.hino.sbb.dao;

import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.ScheduleNode;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
public class ScheduleNodeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ScheduleNode> findAll(){
        return entityManager.createNamedQuery(ScheduleNode.FIND_ALL,ScheduleNode.class).getResultList();
    }

    public ScheduleNode findById(long id)  {
        return entityManager.find(ScheduleNode.class, id);
    }

    public ScheduleNode create(ScheduleNode entity){
        entityManager.persist(entity);
        return entity;
    }

    public ScheduleNode update(ScheduleNode entity){
        entityManager.merge(entity);
        return entity;
    }

    public ScheduleNode delete(ScheduleNode entity){
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }

    public long getStationOrder(long stationId, long trainId){
        Integer order = -1;
        try {
            String query = "SELECT station_order FROM schedules WHERE station_id = :stationId AND train_id = :trainId";
             order = (Integer) entityManager.createNativeQuery(query)
                    .setParameter("stationId",stationId)
                     .setParameter("trainId",trainId)
                    .getSingleResult();
        }
        catch(NoResultException e){

        }
        return order.longValue();

    }
}
