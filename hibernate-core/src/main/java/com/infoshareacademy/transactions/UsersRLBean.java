package com.infoshareacademy.transactions;

import com.infoshareacademy.entities.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.*;
import java.util.Date;

@Stateless
public class UsersRLBean implements UsersRLBeanLocal {

    public void addManyUsers() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        EntityManager em = Persistence.createEntityManagerFactory("puForResourceLocal").createEntityManager();
        em.getTransaction().begin();

        int i = 13;

        User u = new User();
        u.setName("Jan " + i);
        u.setSurname("Kowalski " + i);
        u.setLogin("jako" + i);
        u.setTimestamp(new Date());
        em.persist(u);

        em.flush();

        i++;

        User u1 = new User();
        u1.setName("Jan " + i);
        u1.setSurname("Kowalski " + i);
        u1.setLogin("jako" + i);
        u1.setTimestamp(new Date());
        em.persist(u1);

        em.flush();

        i++;

        User u2 = new User();
        u2.setName("Jan " + i);
        u2.setSurname("Kowalski " + i);
        u2.setLogin("jako" + i);
        u2.setTimestamp(new Date());
        em.persist(u2);

        em.flush();

        em.getTransaction().commit();

        em.close();
    }
}
