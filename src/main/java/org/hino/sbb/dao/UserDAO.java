package org.hino.sbb.dao;

import org.hino.sbb.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll(){
        return entityManager.createNamedQuery(User.FIND_ALL,User.class).getResultList();
    }

    public User findById(long id)  {
        return entityManager.find(User.class, id);
    }

    public User findByName(String username)  {
        User entity = null;
        try {
            entity = (User)entityManager.createQuery("select u from User u where u.username =:username").
                    setParameter("username", username).getSingleResult();
        }catch(Exception e){
            System.out.println( e.toString());
        }
        return entity;
    }

    public User create(User entity){
        entityManager.persist(entity);
        return entity;
    }

    public User update(User entity){
        entityManager.merge(entity);
        return entity;
    }

    public User delete(User entity){
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }
}
