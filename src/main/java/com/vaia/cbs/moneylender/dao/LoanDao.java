/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao;

import com.vaia.cbs.moneylender.dao.exceptions.NonexistentEntityException;
import com.vaia.cbs.moneylender.dao.exceptions.RollbackFailureException;
import com.vaia.cbs.moneylender.entity.Loan;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface LoanDao {

    void create(Loan loan) throws RollbackFailureException, Exception;

    void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception;

    void edit(Loan loan) throws NonexistentEntityException, RollbackFailureException, Exception;

    Loan findLoan(Integer id);

    List<Loan> findLoanEntities();

    List<Loan> findLoanEntities(int maxResults, int firstResult);

    int getLoanCount();
    
}
