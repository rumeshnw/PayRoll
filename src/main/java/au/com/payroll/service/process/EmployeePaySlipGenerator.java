package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 *  Implementation of {@link PaySlipGenerator}
 *
 * @author rnadeera
 */
public class EmployeePaySlipGenerator implements PaySlipGenerator {


    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setFirstName(employee.getFirstName());
        paySlipBuilder.setLastName(employee.getLastName());
        return paySlipBuilder.build();
    }
}
