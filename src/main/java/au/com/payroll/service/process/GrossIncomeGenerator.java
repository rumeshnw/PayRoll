package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Concrete decorator calculate gross income
 *
 * @author rnadeera
 */
public class GrossIncomeGenerator extends PaySlipDecorator {

    public GrossIncomeGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setGrossIncome(Math.round(new Double(employee.getAnnualSalary()) / 12));
        return super.generatePaySlip(paySlipBuilder, employee);
    }
}
