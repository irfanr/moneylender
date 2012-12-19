/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.dao;

import com.vaia.cbs.moneylender.dao.exceptions.NonexistentEntityException;
import com.vaia.cbs.moneylender.dao.exceptions.RollbackFailureException;
import com.vaia.cbs.moneylender.entity.Customer;
import java.util.List;

/**
 *
 * @author irfan
 */
public interface CustomerDao {

    void create(Customer customer);

    void delete(Customer customer);
    void delete(int id);    

    void edit(Customer customer);

    Customer findCustomer(Integer id);

    List<Customer> findCustomer();

    List<Customer> findCustomer(int maxResults, int firstResult);

    int getCustomerCount();
    
}
