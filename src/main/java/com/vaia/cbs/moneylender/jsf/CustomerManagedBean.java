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
    private Customer customer;

    /**
     * Creates a new instance of CustomerManagedBean
     */
    public CustomerManagedBean() {
    }
    
    @PostConstruct
    public void init(){
        
        customers = customerService.search();
        customer = new Customer();
        
    }
    /*
     *  Add Customer ActionListener
     */
    public void addCustomer(){
        
        System.out.println("Add Customer");
        customerService.createCustomer(customer);
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

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
