package au.com.payroll.service;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.transaction.Transactional;

/**
 * Service for handling pay roll related services
 *
 * @author rnadeera
 */
public interface PayrollService extends Transactional {

    /**
     * Generate payslip of given employee
     *
     * @param employee {@link Employee} instance
     * @return {@link PaySlip} instance
     */
    PaySlip generatePaySlip(Employee employee);
}
