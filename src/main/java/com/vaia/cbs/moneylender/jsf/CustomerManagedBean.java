/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.jsf;

import com.vaia.cbs.moneylender.entity.Customer;
import com.vaia.cbs.moneylender.service.CustomerService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author irfan
 */
@ManagedBean
@ViewScoped
public class CustomerManagedBean {
    
    @EJB
    private CustomerService customerService;
    
    private List<Customer> customers;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        
        customers = customerService.search();
        
    }

    /**
     * @return the customers
     */
    public List<Customer> getCustomers() {
        return customers;
    }

    /**
     * @param customers the customers to set
     */
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
