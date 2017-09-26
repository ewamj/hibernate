package com.infoshareacademy.transactions;

import com.infoshareacademy.dao.UsersRelationsBeanLocal;
import com.infoshareacademy.entities.Group;
import com.infoshareacademy.entities.User;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.Date;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UsersTransactionsBean implements UsersTransactionsBeanLocal{

    @PersistenceContext(unitName = "puForJTA")
    EntityManager em;

    @Resource
    UserTransaction ut;

    @Inject
    UsersRelationsBeanLocal users;

    public void addManyUsers() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {

        ut.begin();
        int i = 10;

        User u = new User();
        u.setName("Jan " + i);
        u.setSurname("Kowalski " + i);
        u.setLogin("jako" + i);
        u.setTimestamp(new Date());
        u.setGroupId(users.findGroupByID(1));
        em.persist(u);

        i++;

        User u1 = new User();
        u1.setName("Jan " + i);
        u1.setSurname("Kowalski " + i);
        u1.setLogin("jako" + i);
        u1.setTimestamp(new Date());
        u1.setGroupId(users.findGroupByID(2));
        em.persist(u1);


        i++;

        User u2 = new User();
        u2.setName("Jan " + i);
        u2.setSurname("Kowalski " + i);
        u2.setLogin("jako" + i);
        u2.setGroupId(users.findGroupByID(3));
        u2.setTimestamp(new Date());
        em.persist(u2);

        ut.commit();
    }
}
