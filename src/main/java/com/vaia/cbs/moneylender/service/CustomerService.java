/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.service;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.dao.jpa.CustomerDaoJpa;
import com.vaia.cbs.moneylender.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author irfan
 */
@Stateless
public class CustomerService {

    @EJB
    CustomerDao customerDao;
 
    public int getCountCustomer() {
        return customerDao.getCount();
    }
    
    public void createCustomer(Customer customer) {
        customerDao.create(customer);
    }
    
    public Customer findCustomer(Integer id) {
        return customerDao.find(id);
    }

    
    public void editCustomer(Customer customer) {
        customerDao.edit(customer);
    }

    
    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer.getId());
    }

    
    public void deleteCustomer(int id) {
        customerDao.delete(id);
    }

    
    public List<Customer> searchCustomer() {
        return customerDao.search();
    }

    
    public List<Customer> searchCustomer(int maxResults, int firstResult) {
        return customerDao.search(maxResults, firstResult);
    }
    

}
