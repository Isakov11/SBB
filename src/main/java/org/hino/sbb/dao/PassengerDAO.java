package org.hino.sbb.dao;

import org.hino.sbb.model.Passenger;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.util.List;

@Repository
public class PassengerDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Passenger> findAll(){
        return entityManager.createNamedQuery(Passenger.FIND_ALL,Passenger.class).getResultList();
    }

    public Passenger findById(long id){
        return entityManager.find(Passenger.class, id);
    }

    public Passenger create(Passenger passenger){
        entityManager.persist(passenger);
        return passenger;
    }

    public Passenger update(Passenger passenger){
        entityManager.merge(passenger);
        return passenger;
    }

    public Passenger delete(Passenger passenger){
        if (entityManager.contains(passenger)) {
            entityManager.remove(passenger);
        } else {
            entityManager.remove(entityManager.merge(passenger));
        }
        return passenger;
    }

    public boolean isPassengerRegisteredOnTrain(Passenger passenger,long trainId){
        String query = "SELECT EXISTS (SELECT id FROM passengers WHERE " +
                "(name = :name AND second_name = :secondName AND birth_date = :birthDate ) " +
                "AND id IN(SELECT passenger_id AS id FROM tickets WHERE train_id = :trainId ))";
        BigInteger check = (BigInteger) entityManager.createNativeQuery(query)
                .setParameter("name",passenger.getName())
                .setParameter("secondName",passenger.getSecondName())
                .setParameter("birthDate",passenger.getBirthDate())
                .setParameter("trainId",trainId).getSingleResult();
        return (check.equals(BigInteger.ONE));
    }

    public Passenger findByAllCols(Passenger passenger){
        Passenger entity = null;
        try {
            entity = (Passenger) entityManager.createQuery("select p from Passenger p " +
                    "where (p.name= :name and p.secondName= :secondName and p.birthDate= :birthDate)").
                    setParameter("secondName", passenger.getSecondName()).
                    setParameter("name", passenger.getName()).
                    setParameter("birthDate", passenger.getBirthDate()).getSingleResult();
        }
        catch(NoResultException e){

        }
        return entity;
    }
}
