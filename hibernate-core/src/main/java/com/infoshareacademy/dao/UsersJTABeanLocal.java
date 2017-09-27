package com.infoshareacademy.dao;

import javax.ejb.Local;

@Local
public interface UsersJTABeanLocal {
    void addUser();
    void updateUser(int id);
    void deleteUser(int id);
}
