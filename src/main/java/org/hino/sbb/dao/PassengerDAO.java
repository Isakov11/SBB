package org.hino.sbb.dao;

import org.hino.sbb.model.Passenger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


@Repository
@Transactional
public class PassengerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional (readOnly = true)
    public List<Passenger> findAll(){
        return entityManager.createNamedQuery(Passenger.FIND_ALL,Passenger.class).getResultList();
    }

    @Transactional (readOnly = true)
    public Passenger findById(long id){
        TypedQuery<Passenger> query = entityManager.createNamedQuery(Passenger.FIND_By_Id,Passenger.class);
        return query.setParameter("id", id).getSingleResult();
    }

    @Transactional
    public Passenger create(Passenger passenger){
        entityManager.persist(passenger);
        return passenger;
    }

    @Transactional
    public Passenger update(Passenger passenger){
        entityManager.merge(passenger);
        return passenger;
    }

    @Transactional
    public Passenger delete(Passenger passenger){
        if (entityManager.contains(passenger)) {
            entityManager.remove(passenger);
        } else {
            entityManager.remove(entityManager.merge(passenger));
        }
        return passenger;
    }
}
