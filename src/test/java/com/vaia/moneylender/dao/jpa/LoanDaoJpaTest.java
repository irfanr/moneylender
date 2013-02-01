/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.moneylender.dao.jpa;

import com.vaia.cbs.moneylender.dao.CustomerDao;
import com.vaia.cbs.moneylender.dao.LoanDao;
import com.vaia.cbs.moneylender.dao.jpa.CustomerDaoJpa;
import com.vaia.cbs.moneylender.dao.jpa.LoanDaoJpa;
import com.vaia.cbs.moneylender.entity.Customer;
import com.vaia.cbs.moneylender.entity.Loan;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author irfan
 */
public class LoanDaoJpaTest {

    Logger logger = Logger.getLogger(LoanDaoJpaTest.class);
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static CustomerDao customerDao;
    private static LoanDao loanDao;
    private Customer customer = null;
    private static int customerId = 1236;
    private Loan loan = null;

    public LoanDaoJpaTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @BeforeClass
    public static void setUpClass() throws Exception {
        emf = Persistence.createEntityManagerFactory("moneylenderPU-local");
        em = emf.createEntityManager();
        customerDao = new CustomerDaoJpa(em);
        loanDao = new LoanDaoJpa(em);

    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(enabled = true)
    public void testCreateLoan() {
        logger.info(" === testCreateLoan ===");

        customer = customerDao.find(customerId);

        loan = new Loan();
        loan.setAmount(2000000.0);
        loan.setCustomer(customer);

        em.getTransaction().begin();
        loanDao.create(loan);
        em.getTransaction().commit();

        logger.info("loan.getId():" + loan.getId());
        Assert.assertNotNull(loan.getId());

    }

    @Test(dependsOnMethods = {"testCreateLoan"})
    public void testFindLoan() {
        logger.info(" === testFindLoan ===");

        loan = loanDao.find(loan.getId());

        logger.info("loan.getId():" + loan.getId());
        Assert.assertNotNull(loan);

    }

    @Test(dependsOnMethods = {"testFindLoan"})
    public void testUpdateLoan() {
        logger.info(" === testUpdateLoan ===");

        loan = loanDao.find(loan.getId());
        loan.setAmount(1000000.0);

        em.getTransaction().begin();
        loanDao.edit(loan);
        em.getTransaction().commit();

        logger.info(" loan.getAmount():" + loan.getAmount());
        Assert.assertEquals(loan.getAmount(), 1000000.0);

    }

    @Test(dependsOnMethods = {"testUpdateLoan"})
    public void testDeleteLoan() {
        logger.info(" === testDeleteLoan ===");

        loan = loanDao.find(loan.getId());

        em.getTransaction().begin();
        int loanId = loan.getId();
        loanDao.delete(loan);
        em.getTransaction().commit();

        loan = loanDao.find(loanId);
        Assert.assertNull(loan);

    }
}
