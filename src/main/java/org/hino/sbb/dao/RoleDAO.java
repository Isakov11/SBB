package org.hino.sbb.dao;

import org.hino.sbb.model.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Role> findAll(){
        return entityManager.createNamedQuery(Role.FIND_ALL,Role.class).getResultList();
    }

    public Role findByName(String role)  {
        return (Role) entityManager.createQuery("SELECT r FROM Role r WHERE r.role = :role", Role.class)
                .setParameter("role", role)
                .getSingleResult();
    }

    public Role create(Role entity){
        entityManager.persist(entity);
        return entity;
    }

    public Role update(Role entity){
        entityManager.merge(entity);
        return entity;
    }

    public Role delete(Role entity){
        if (entityManager.contains(entity)) {
            entityManager.remove(entity);
        } else {
            entityManager.remove(entityManager.merge(entity));
        }
        return entity;
    }
}
