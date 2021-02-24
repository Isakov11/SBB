package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.Train;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class TrainDAO {
    private static final Logger logger = Logger.getLogger(TrainDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Train> findAll(){
        try {
            return entityManager.createNamedQuery(Train.FIND_ALL,Train.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Train findById(long id)  {
        try {
            return entityManager.find(Train.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Train create(Train train){
        try {
            entityManager.persist(train);
            return train;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Train update(Train train){
        try {
            entityManager.merge(train);
            return train;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Train delete(Train train){
        try {
            if (entityManager.contains(train)) {
                entityManager.remove(train);
            } else {
                entityManager.remove(entityManager.merge(train));
            }
        }catch(Exception e){
            logger.error(e.toString());
        }
        return train;
    }

    public List<Train> getTrainsByStationId(long id)  {
        String query = "SELECT * from trains where id IN(SELECT train_id as id from schedules where station_id = :id)";
        List<Train> trains = null;
        try {
            trains = entityManager.createNativeQuery(query, Train.class).setParameter("id",id) .getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return trains;
    }

    //Improved query
    public List<Train> getTrainsByDepartAndArrivalStationIds(long departId,long arrivalId)  {
        String query = "SELECT t.id, t.name, t.number, t.seats_number from trains t\n" +
                "INNER JOIN schedules s ON (s.train_id = t.id AND s.station_id = :departId)\n" +
                "INNER JOIN schedules s1 ON (s1.train_id = t.id AND s1.station_id = :arrivalId)\n" +
                "WHERE \n" +
                "s.departure_time < s1.arrival_time";
        List<Train> trains = null;
        try {
            trains = entityManager.createNativeQuery(query, Train.class).setParameter("departId",departId)
                .setParameter("arrivalId",arrivalId)
                .getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return trains;
    }

    public List<Train> getTrainsByDepartAndArrivalStationIdsAndDate(long departId,long arrivalId, LocalDate departDate)  {
        String departDateS = departDate.toString();
        String query = "SELECT t.id, t.name, t.number, t.seats_number from trains t\n" +
                "INNER JOIN schedules s ON (s.train_id = t.id AND s.station_id = :departId)\n" +
                "INNER JOIN schedules s1 ON (s1.train_id = t.id AND s1.station_id = :arrivalId)\n" +
                "WHERE \n" +
                "s.departure_time < s1.arrival_time \n" +
                "AND \n" +
                "Date(s.departure_time) = :departDate";
        List<Train> trains = null;
        try {
            trains = entityManager.createNativeQuery(query, Train.class)
                .setParameter("departId",departId)
                .setParameter("arrivalId",arrivalId)
                .setParameter("departDate",departDateS)
                .getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return trains;

    }

    public boolean isTrainHasFreeSeats(long trainId)  {
        String query = "SELECT EXISTS (Select * from trains where id=:trainId and " +
                "(Select COUNT(*) as number from tickets where train_id = :trainId) < " +
                "(SELECT seats_number from trains where id = :trainId))";
        boolean checker = false;
        try {
            BigInteger check = (BigInteger) entityManager.createNativeQuery(query)
                    .setParameter("trainId",trainId).getSingleResult();
            checker = check.equals(BigInteger.ONE);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return checker;
    }

    public LocalDateTime getTrainDepartureTimeFromStation(long trainId, long stationId){
        String query = "SELECT departure_time FROM schedules where train_id = :trainId and station_id = :stationId";
        Timestamp timeStamp = null;
        try {
            timeStamp = (Timestamp) entityManager.createNativeQuery(query).setParameter("trainId",trainId)
                .setParameter("stationId",stationId).getSingleResult();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return timeStamp.toLocalDateTime();
    }
}
