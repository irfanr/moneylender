/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vaia.cbs.moneylender.jsf;

import com.vaia.cbs.moneylender.entity.Loan;
import com.vaia.cbs.moneylender.service.LoanService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;

/**
 *
 * @author irfan
 */
@ManagedBean
@ViewScoped
public class LoanManagedBean implements Serializable {

    public static final String FORM_TABLE_ID = "formLoanTable";
    public static final String FORM_DETAIL_ID = "formLoanFields";
    @EJB
    private LoanService loanService;
    private List<Loan> loans;
    private Loan loan;

    /**
     * Creates a new instance of LoanManagedBean
     */
    public LoanManagedBean() {
    }

    @PostConstruct
    public void init() {

        loans = loanService.searchLoan();
        loan = new Loan();
    }

    public void prepareFormAdd() {

        this.loan = new Loan();

        // Scroll to form 
        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Add Loan ActionListener
     */
    public void addLoan() {

        System.out.println("Add Loan");
        loanService.createLoan(loan);

        loans = loanService.searchLoan();

        prepareFormEdit(loan);
    }

    public void prepareFormEdit(Loan editedLoan) {

        this.loan = loanService.findLoan(editedLoan.getId());

        scrollToForm(FORM_DETAIL_ID);
    }

    /*
     *  Edit Loan ActionListener
     */
    public void editLoan() {

        System.out.println("Edit Loan");
        loanService.editLoan(loan);

        loans = loanService.searchLoan();

        prepareFormEdit(loan);
    }

    public void prepareDelete(Loan deletedLoan) {

        this.loan = deletedLoan;

    }


    /*
     *  Delete Loan ActionListener
     */
    public void deleteLoan() {

        System.out.println("Delete Loan");
        loanService.deleteLoan(loan);

        loans = loanService.searchLoan();

        prepareFormAdd();

//        scrollToForm(FORM_TABLE_ID);        
    }

    private void scrollToForm(String componentId) {
        // Scroll to form 
        RequestContext.getCurrentInstance().scrollTo(componentId);
    }

    /**
     * @return the loanService
     */
    public LoanService getLoanService() {
        return loanService;
    }

    /**
     * @param loanService the loanService to set
     */
    public void setLoanService(LoanService loanService) {
        this.loanService = loanService;
    }

    /**
     * @return the loans
     */
    public List<Loan> getLoans() {
        return loans;
    }

    /**
     * @param loans the loans to set
     */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    /**
     * @return the loan
     */
    public Loan getLoan() {
        return loan;
    }

    /**
     * @param loan the loan to set
     */
    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    /**
     * @return the formLegendTitle
     */
    public String getFormLegendTitle() {
        
        if( loan.getId() != null ){
            
            return "Edit Loan" + ": " + loan.getCustomer().getName();
        }
        else{
            return "Add Loan";
        }        
    }

}
