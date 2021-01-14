package org.hino.sbb.dao;

import org.hino.sbb.model.Train;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TrainDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional (readOnly = true)
    public List<Train> findAll(){
        return entityManager.createNamedQuery(Train.FIND_ALL,Train.class).getResultList();
    }

    @Transactional (readOnly = true)
    public Train findById(long id)  {
        return entityManager.find(Train.class, id);
    }

    public Train create(Train train){
        entityManager.persist(train);
        return train;
    }

    public Train update(Train train){
        entityManager.merge(train);
        return train;
    }

    public Train delete(Train train){
        if (entityManager.contains(train)) {
            entityManager.remove(train);
        } else {
            entityManager.remove(entityManager.merge(train));
        }
        return train;
    }
}
