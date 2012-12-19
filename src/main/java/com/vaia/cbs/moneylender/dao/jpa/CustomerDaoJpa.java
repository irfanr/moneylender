/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.dao.exceptions.NonexistentEntityException;
import com.vaia.cbs.moneylender.dao.exceptions.RollbackFailureException;
import com.vaia.cbs.moneylender.entity.Customer;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.vaia.cbs.moneylender.entity.Loan;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author irfan
 */
public class CustomerDaoJpa implements Serializable, CustomerDao {
    
    private EntityManager em;

    public CustomerDaoJpa(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void create(Customer customer) {
        em.persist(customer);
    }

    @Override
    public void delete(Customer customer) {
        em.remove(customer);
    }
    
    @Override
    public void delete(int id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }    

    @Override
    public void edit(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer findCustomer(Integer id) {        
        return em.find(Customer.class, id);
    }

    @Override
    public List<Customer> findCustomer() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> findCustomer(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCustomerCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    

  
}
