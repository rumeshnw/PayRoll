package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * @author rnadeera
 */
public class EmployeePaySlip extends PaySlipHandler {


    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setFirstName(employee.getFirstName());
        paySlipBuilder.setLastName(employee.getLastName());
        return paySlipBuilder.build();
    }
}
