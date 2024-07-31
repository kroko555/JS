package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveRole(Role role) {
        em.persist(role);
    }

    @Override
    public Role getRole(String role) {
        Query query = em.createQuery("SELECT r FROM Role r WHERE r.roleName = :roleName");
        query.setParameter("roleName", role);
        return (Role) query.getSingleResult();
    }

}
