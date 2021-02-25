package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.controller.GlobalExceptionHandler;
import org.hino.sbb.model.Passenger;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.math.BigInteger;
import java.util.List;

@Repository
public class PassengerDAO {
    private static final Logger logger = Logger.getLogger(PassengerDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Passenger> findAll(){
        try{
            return entityManager.createNamedQuery(Passenger.FIND_ALL,Passenger.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Passenger findById(long id){
        try{
            return entityManager.find(Passenger.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Passenger create(Passenger passenger){
        try{
            entityManager.persist(passenger);
            return passenger;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Passenger update(Passenger passenger){
        try{
            entityManager.merge(passenger);
            return passenger;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Passenger delete(Passenger passenger){
        try{
            if (entityManager.contains(passenger)) {
                entityManager.remove(passenger);
            } else {
                entityManager.remove(entityManager.merge(passenger));
            }
        }catch(Exception e){
            logger.error(e.toString());
        }
        return passenger;
    }

    public boolean isPassengerRegisteredOnTrain(Passenger passenger,long trainId){
        BigInteger check = BigInteger.ZERO;
        String query = "SELECT EXISTS (SELECT id FROM passengers WHERE " +
                "(name = :name AND second_name = :secondName AND birth_date = :birthDate ) " +
                "AND id IN(SELECT passenger_id AS id FROM tickets WHERE train_id = :trainId ))";
        try{
        check = (BigInteger) entityManager.createNativeQuery(query)
                .setParameter("name",passenger.getName())
                .setParameter("secondName",passenger.getSecondName())
                .setParameter("birthDate",passenger.getBirthDate())
                .setParameter("trainId",trainId).getSingleResult();
        }catch(Exception e){
            logger.error(e.toString());
        }
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
        catch(Exception e){
            logger.error(e.getMessage());
        }
        return entity;
    }
}
