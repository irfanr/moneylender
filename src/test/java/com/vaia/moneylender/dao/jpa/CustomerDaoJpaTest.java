/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.dao.jpa.CustomerDaoJpa;
import com.vaia.cbs.moneylender.entity.Customer;
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

    @Test(enabled = false)
    public void testCreateCustomer() {
        logger.info(" === testCreateCustomer ===");

        Customer customer = new Customer();
        customer.setName("Irfan");

        em.getTransaction().begin();
        customerDao.create(customer);
        em.getTransaction().commit();

        logger.info("customer.getId():" + customer.getId());
        Assert.assertNotNull(customer.getId());

    }

    @Test(enabled = false)
    public void testFindCustomer() {
        logger.info(" === testFindCustomer ===");

        Customer customer = customerDao.findCustomer(1237);

        logger.info("customer.getId():" + customer.getId());
        Assert.assertNotNull(customer);

    }

    @Test(enabled = false)
    public void testUpdateCustomer() {
        logger.info(" === testUpdateCustomer ===");

        Customer customer = customerDao.findCustomer(1237);
        customer.setName("Romadona");

        em.getTransaction().begin();
        customerDao.edit(customer);
        em.getTransaction().commit();

        logger.info(" customer.getName():" + customer.getName());
        Assert.assertEquals(customer.getName(), "Romadona");

    }

    @Test(enabled = false)
    public void testDeleteCustomer() {
        logger.info(" === testDeleteCustomer ===");

        Customer customer = customerDao.findCustomer(1237);

        em.getTransaction().begin();
        customerDao.delete(customer);
        em.getTransaction().commit();
        
        customer = customerDao.findCustomer(1237);
        Assert.assertNull(customer);

    }
}
