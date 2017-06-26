package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 *  Implementation of {@link PaySlipHandler}
 *
 * @author rnadeera
 */
public class EmployeePaySlip implements PaySlipHandler {


    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setFirstName(employee.getFirstName());
        paySlipBuilder.setLastName(employee.getLastName());
        return paySlipBuilder.build();
    }
}
