package com.infoshareacademy.dao;

import com.infoshareacademy.entities.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@Stateless
public class UsersJTABean implements UsersJTABeanLocal {

    @PersistenceContext(unitName = "puForJTA")
    private EntityManager em;

    @Inject
    UsersRelationsBeanLocal users;

    public void addUser() {

        User u = new User();
        int i = 6;
        u.setName("Jan " + i);
        u.setSurname("Kowalski " + i);
        u.setLogin("jako" + i);
        u.setTimestamp(new Date());
//        u.setTimestamp(new Date(new Date().getTime() + 1000000000));
        u.setGroupId(users.findGroupByID(1));

        em.persist(u);
        em.flush();
    }

    @Override
    public void updateUser(int id) {
        User user = em.find(User.class, id);
        user.setName(user.getName() + " -updated");
        em.merge(user);
    }
}
