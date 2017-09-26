package com.infoshareacademy.dao;

import com.infoshareacademy.entities.Group;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;


@Stateless
public class UsersRelationsBean implements UsersRelationsBeanLocal {

    @PersistenceContext(unitName = "puForJTA")
    private EntityManager em;

    public List getAllUsers() {
        return null;
    }

    public Group findGroupByID(int id) {
        Group group = em.find(Group.class, id);
        return group;
    }
}
