package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Interface to handle pay slip generation
 *
 * @author rnadeera
 */
public interface PaySlipHandler {

    PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee);

}
