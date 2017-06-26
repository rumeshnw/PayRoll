package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Concrete decorator calculate gross income
 *
 * @author rnadeera
 */
public class GrossIncomeDecorator extends PaySlipDecorator {

    public GrossIncomeDecorator(PaySlipHandler paySlipHandler) {
        super(paySlipHandler);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setGrossIncome(Math.round(new Double(employee.getAnnualSalary()) / 12));
        return super.generatePaySlip(paySlipBuilder, employee);
    }
}
