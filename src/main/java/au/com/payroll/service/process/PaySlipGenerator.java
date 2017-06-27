package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Interface to handle pay slip generation
 *
 * @author rnadeera
 */
public interface PaySlipGenerator {

    PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee);

}
