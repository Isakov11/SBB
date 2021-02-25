package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.ScheduleNode;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ScheduleNodeDAO {
    private static final Logger logger = Logger.getLogger(ScheduleNodeDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<ScheduleNode> findAll(){
        try{
            return entityManager.createNamedQuery(ScheduleNode.FIND_ALL,ScheduleNode.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public ScheduleNode findById(long id)  {
        try{
            return entityManager.find(ScheduleNode.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public ScheduleNode create(ScheduleNode entity){
        try{
            entityManager.persist(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public ScheduleNode update(ScheduleNode entity){
        try{
            entityManager.merge(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public ScheduleNode delete(ScheduleNode entity){
        try{
            if (entityManager.contains(entity)) {
                entityManager.remove(entity);
            } else {
                entityManager.remove(entityManager.merge(entity));
            }
        }catch(Exception e){
            logger.error(e.toString());
        }
        return entity;
    }
}
