/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.entity.Customer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

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
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void create(Customer customer) {
        em.persist(customer);
    }

    @Override
    public Customer find(Integer id) {
        return em.find(Customer.class, id);
    }

    @Override
    public void edit(Customer customer) {
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
    public List<Customer> search() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Customer> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
