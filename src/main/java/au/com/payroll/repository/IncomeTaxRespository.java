package au.com.payroll.repository;

import au.com.payroll.domain.IncomeTax;

import java.util.Optional;

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
    Optional<IncomeTax> findByIncomeBracket(int income);
}
