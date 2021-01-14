package org.hino.sbb.dao;

import org.hino.sbb.model.Station;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class StationDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional (readOnly = true)
    public List<Station> findAll(){
        return entityManager.createNamedQuery(Station.FIND_ALL,Station.class).getResultList();
    }

    @Transactional (readOnly = true)
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

    public Station delete(Station station){
        if (entityManager.contains(station)) {
            entityManager.remove(station);
        } else {
            entityManager.remove(entityManager.merge(station));
        }
        return station;
    }
}
