/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.service;

import com.vaia.cbs.moneylender.dao.LoanDao;
import com.vaia.cbs.moneylender.entity.Loan;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author irfan
 */
@Stateless
public class LoanService {
    
    @EJB
    LoanDao loanDao;

    public int getCount() {
        return loanDao.getCount();
    }

    public void createLoan(Loan loan) {
        loanDao.create(loan);
    }

    public Loan findLoan(Integer id) {
        return loanDao.find(id);
    }

    public void editLoan(Loan loan) {
        loanDao.edit(loan);
    }

    public void deleteLoan(Loan loan) {
        loanDao.delete(loan);
    }

    public void deleteLoan(int id) {
        loanDao.delete(id);
    }

    public List<Loan> searchLoan() {
        return loanDao.search();
    }

    public List<Loan> searchLoan(int maxResults, int firstResult) {
        return loanDao.search(maxResults, firstResult);
    }
}
