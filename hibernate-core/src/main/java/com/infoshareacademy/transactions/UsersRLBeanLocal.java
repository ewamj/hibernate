package com.infoshareacademy.transactions;

import javax.ejb.Local;
import javax.transaction.*;

@Local
public interface UsersRLBeanLocal {

    void addManyUsers() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException;
}
