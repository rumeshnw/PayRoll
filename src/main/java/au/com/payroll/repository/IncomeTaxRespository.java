package au.com.payroll.repository;

import au.com.payroll.domain.IncomeTax;

/**
 * @author rnadeera
 */
public interface IncomeTaxRespository {

    /**
     * Get respective {@link IncomeTax} record by employee annual salary
     *
     * @param income Annual salary of the employee
     * @return {@link IncomeTax} instance
     */
    IncomeTax findByIncomeBracket(long income);
}
