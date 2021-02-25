package org.hino.sbb.dao;

import org.apache.log4j.Logger;
import org.hino.sbb.model.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAO {
    private static final Logger logger = Logger.getLogger(RoleDAO.class);

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> findAll(){
        try{
            return entityManager.createNamedQuery(Role.FIND_ALL,Role.class).getResultList();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Role findByName(String role)  {
        try{
            return entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Role create(Role entity){
        try{
            entityManager.persist(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Role update(Role entity){
        try{
            entityManager.merge(entity);
            return entity;
        }catch(Exception e){
            logger.error(e.toString());
        }
        return null;
    }

    public Role delete(Role entity){
        try{
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
