package com.infoshareacademy.transactions;

import javax.ejb.Local;
import javax.transaction.*;

@Local
public interface UsersTransactionsBeanLocal {

    void addManyUsers() throws SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException;
}
