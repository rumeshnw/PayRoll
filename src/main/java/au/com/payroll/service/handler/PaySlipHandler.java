package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Abstract class handle pay slip generation
 *
 * @author rnadeera
 */
public abstract class PaySlipHandler {

    public abstract PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee);

}
