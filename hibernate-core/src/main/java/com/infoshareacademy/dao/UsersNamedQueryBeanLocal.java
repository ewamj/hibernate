package com.infoshareacademy.dao;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UsersNamedQueryBeanLocal {
    List getUser(String name);
    Object getUsersCount(String name);
}
