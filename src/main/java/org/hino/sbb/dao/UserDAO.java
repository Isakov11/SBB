package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.List;

@Repository
public class UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll(){
        try {
            return entityManager.createNamedQuery(User.FIND_ALL,User.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public User findById(long id)  {
        try {
            return entityManager.find(User.class, id);
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public User findByName(String username)  {
        User entity = null;
        try {
            entity = (User)entityManager.createQuery("select u from User u where u.username =:username").
                    setParameter("username", username).getSingleResult();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return entity;
    }

    public User create(User entity){
        try {
            entityManager.persist(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public User update(User entity){
        try {
            entityManager.merge(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public User delete(User entity){
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
