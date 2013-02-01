/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.dao.jpa.CustomerDaoJpa;
import com.vaia.cbs.moneylender.entity.Customer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author irfan
 */
public class CustomerDaoJpaTest {

    Logger logger = Logger.getLogger(CustomerDaoJpaTest.class);
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static CustomerDao customerDao;
    
    private Customer customer = null;

    public CustomerDaoJpaTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("moneylenderPU-local");
        em = emf.createEntityManager();
        customerDao = new CustomerDaoJpa(em);
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(enabled = true)
    public void testCreateCustomer() {
        logger.info(" === testCreateCustomer ===");

        customer = new Customer();
        customer.setName("Irfan");

        em.getTransaction().begin();
        customerDao.create(customer);
        em.getTransaction().commit();

        logger.info("customer.getId():" + customer.getId());
        Assert.assertNotNull(customer.getId());

    }

    @Test(dependsOnMethods={"testCreateCustomer"})
    public void testFindCustomer() {
        logger.info(" === testFindCustomer ===");

        customer = customerDao.find(customer.getId());

        logger.info("customer.getId():" + customer.getId());
        Assert.assertNotNull(customer);

    }

    @Test(dependsOnMethods={"testFindCustomer"})
    public void testUpdateCustomer() {
        logger.info(" === testUpdateCustomer ===");

        customer = customerDao.find(customer.getId());
        customer.setName("Romadona");

        em.getTransaction().begin();
        customerDao.edit(customer);
        em.getTransaction().commit();

        logger.info(" customer.getName():" + customer.getName());
        Assert.assertEquals(customer.getName(), "Romadona");

    }

    @Test(dependsOnMethods={"testUpdateCustomer"})
    public void testDeleteCustomer() {
        logger.info(" === testDeleteCustomer ===");

        customer = customerDao.find(customer.getId());

        em.getTransaction().begin();
        int customerId = customer.getId();
        customerDao.delete(customer);
        em.getTransaction().commit();
        
        customer = customerDao.find(customerId);
        Assert.assertNull(customer);

    }
}
