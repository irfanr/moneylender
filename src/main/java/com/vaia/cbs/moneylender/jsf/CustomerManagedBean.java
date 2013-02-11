/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.jsf;

import com.vaia.cbs.moneylender.entity.Customer;
import com.vaia.cbs.moneylender.service.CustomerService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author irfan
 */
@ManagedBean
@ViewScoped
public class CustomerManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formCustomerTable";
    public static final String FORM_DETAIL_ID = "formCustomerFields";
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
    public void init() {

        customers = customerService.searchCustomer();
        customer = new Customer();

    }

    public void prepareFormAdd() {

        this.customer = new Customer();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Customer ActionListener
     */
    public void addCustomer() {

        System.out.println("Add Customer");
        customerService.createCustomer(customer);

        customers = customerService.searchCustomer();

        prepareFormEdit(customer);
    }

    public void prepareFormEdit(Customer editedCustomer) {

        this.customer = customerService.findCustomer(editedCustomer.getId());

        scrollToForm(FORM_DETAIL_ID);

    }

    /*
     *  Edit Customer ActionListener
     */
    public void editCustomer() {

        System.out.println("Edit Customer");
        customerService.editCustomer(customer);

        customers = customerService.searchCustomer();

        prepareFormEdit(customer);
    }

    public void prepareDelete(Customer deletedCustomer) {

        this.customer = deletedCustomer;

    }

    /*
     *  Delete Customer ActionListener
     */
    public void deleteCustomer() {

        System.out.println("Delete Customer");
        customerService.deleteCustomer(customer);

        customers = customerService.searchCustomer();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);
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

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
    }
}
