package com.infoshareacademy.dao;

import com.infoshareacademy.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Stateless
public class UsersNamedQueryBean implements UsersNamedQueryBeanLocal {

    @PersistenceContext(unitName = "puForJTA")
    private EntityManager em;


    public List getUser(String name) {
        Query q = em.createNamedQuery("com.infoshareacademy.entities.User.userByName");
        q.setParameter("name", "Jan");
        return q.getResultList();
    }

    public Object getUsersCount(String name) {
        Query q = em.createNamedQuery("com.infoshareacademy.entities.User.userCountByName");
        q.setParameter("name", "Jan");
        return q.getSingleResult();
    }
}
