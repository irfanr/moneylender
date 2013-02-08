/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.entity.Customer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author irfan
 */
@Stateless
public class CustomerDaoJpa implements Serializable, CustomerDao {

    @PersistenceContext(unitName="moneylenderPU")
    private EntityManager em;

    public CustomerDaoJpa() {
    }

    public CustomerDaoJpa(EntityManager em) {
        this.em = em;
    }
    
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
        em.merge(customer);
    }

    @Override
    public void delete(Customer customer) {
        em.merge(customer);
        em.remove(customer);
    }

    @Override
    public void delete(int id) {
        Customer customer = em.find(Customer.class, id);
        em.remove(customer);
    }

    @Override
    public List<Customer> search() {
        return em.createQuery("select c from Customer c").getResultList();
    }

    
    public List<Customer> search(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
