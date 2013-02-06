/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.LoanDao;
import com.vaia.cbs.moneylender.entity.Loan;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author irfan
 */
@Stateless
public class LoanDaoJpa implements Serializable, LoanDao {

    @PersistenceContext
    private EntityManager em;

    public LoanDaoJpa(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Loan loan) {
        em.persist(loan);
    }

    @Override
    public Loan find(Integer id) {
        return em.find(Loan.class, id);
    }

    @Override
    public void edit(Loan loan) {
        em.persist(loan);
    }

    @Override
    public void delete(Loan loan) {
        em.remove(loan);
    }

    @Override
    public void delete(int id) {
        Loan loan = em.find(Loan.class, id);
        em.remove(loan);
    }

    @Override
    public List<Loan> search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Loan> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
