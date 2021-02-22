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
            logger.warn("Exception in StationDAO - findAll()");
        }
        return stationList;
    }

    public Station findById(long id)  {
        return entityManager.find(Station.class, id);
    }

    public Station create(Station station){
        entityManager.persist(station);
        return station;
    }

    public Station update(Station station){
        entityManager.merge(station);
        return station;
    }

    public Station delete(Station station) {
        try {
            entityManager.remove(station);
        }catch(Exception e){
            logger.warn("Exception in StationDAO - delete()");
        }
        return station;
    }
}
