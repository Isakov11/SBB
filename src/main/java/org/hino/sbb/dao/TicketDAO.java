package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.Ticket;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TicketDAO {
    private static final Logger logger = Logger.getLogger(TicketDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ticket> findAll(){
        try {
            return entityManager.createNamedQuery(Ticket.FIND_ALL,Ticket.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Ticket findById(long id)  {
        try {
            return entityManager.find(Ticket.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public List<Ticket> findByTrain(long trainId)  {
        try {
            List<Ticket> tickets = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.ticketTrain.id = :trainId")
                .setParameter("trainId",trainId)
                .getResultList();
        return tickets;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Ticket create(Ticket entity){
        try {
            entityManager.persist(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Ticket update(Ticket entity){
        try {
            entityManager.merge(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Ticket delete(Ticket entity){
        try {
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
