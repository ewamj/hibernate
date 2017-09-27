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
    UsersRelationsBeanLocal users; // za każdym wstrzyknięciem wszystko do nowa jak stateless

    public void addUser() {

        User u = new User();
        int i = 6;
        u.setName("Jan " + i);
        u.setSurname("Kowalski " + i);
        u.setLogin("jako" + i);
        u.setTimestamp(new Date());
//        u.setTimestamp(new Date(new Date().getTime() + 1000000000));
        u.setGroupId(users.findGroupByID(1));

        em.persist(u); // tworzy kopie lokalna entity managera na hibernate, tlumaczy i utrwala w db, transakcja jest obslugiwana przez kontener ----------- samo utworzenie pol - wierszy, nie zapisuje, aby zapisac, trzeba przekazac do persista
        em.flush(); // czysci zainicjalizowanego em przed kolejnym uzyciem
    }

    @Override
    public void updateUser(int id) {
        User user = em.find(User.class, id);
        user.setName(user.getName() + " -updated");
        em.merge(user);
    }

    public void deleteUser(int id) {
        User user = em.find(User.class,id); //find szuka tylko poo kluczach głównych
        em.remove(user);

    }
}
