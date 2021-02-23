package org.hino.sbb.dao;

import org.hino.sbb.model.Ticket;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TicketDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Ticket> findAll(){
        return entityManager.createNamedQuery(Ticket.FIND_ALL,Ticket.class).getResultList();
    }

    public Ticket findById(long id)  {
        return entityManager.find(Ticket.class, id);
    }

    public List<Ticket> findByTrain(long trainId)  {
        List<Ticket> tickets = entityManager.createQuery("SELECT t FROM Ticket t WHERE t.ticketTrain.id = :trainId")
                .setParameter("trainId",trainId)
                .getResultList();
        return tickets;
    }

    public Ticket create(Ticket entity){
        entityManager.persist(entity);
        return entity;
    }

    public Ticket update(Ticket entity){
        entityManager.merge(entity);
        return entity;
    }

    public Ticket delete(Ticket entity){
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }
}
