package org.hino.sbb.dao;

import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ScheduleNodeDAO {

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
