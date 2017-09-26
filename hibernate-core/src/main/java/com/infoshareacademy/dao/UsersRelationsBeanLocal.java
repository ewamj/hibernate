package com.infoshareacademy.dao;

import com.infoshareacademy.entities.Group;

import javax.ejb.Local;
import javax.transaction.*;
import java.util.List;

@Local
public interface UsersRelationsBeanLocal {
    List getAllUsers();
    Group findGroupByID(int id);
}
