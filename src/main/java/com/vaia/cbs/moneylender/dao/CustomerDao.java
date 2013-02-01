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

    int getCount();

    void create(Customer customer);

    Customer find(Integer id);

    void edit(Customer customer);

    void delete(Customer customer);

    void delete(int id);

    List<Customer> search();

    List<Customer> search(int maxResults, int firstResult);
}
