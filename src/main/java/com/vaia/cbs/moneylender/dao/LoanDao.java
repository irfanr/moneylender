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

    int getCount();

    void create(Loan loan);

    Loan find(Integer id);

    void edit(Loan loan);

    void delete(Loan loan);

    void delete(int id);

    List<Loan> search();

    List<Loan> search(int maxResults, int firstResult);
    
}
