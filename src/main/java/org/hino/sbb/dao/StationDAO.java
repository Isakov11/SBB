package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.Station;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Repository
public class StationDAO {
    private static final Logger logger = Logger.getLogger(StationDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Station> findAll() {
        List<Station> stationList = new LinkedList<>();
        try{
            stationList = entityManager.createNamedQuery(Station.FIND_ALL, Station.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return stationList;
    }

    public Station findById(long id)  {
        try{
            return entityManager.find(Station.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Station create(Station station){
        try{
            entityManager.persist(station);
            return station;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Station update(Station station){
        try{
            entityManager.merge(station);
            return station;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Station delete(Station station) {
        try {
            entityManager.remove(station);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return station;
    }
}
