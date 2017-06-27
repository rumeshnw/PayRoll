package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Concrete decorator to calculate net income
 *
 * @author rnadeera
 */
public class NetIncomeGenerator extends PaySlipDecorator {

    public NetIncomeGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setNetIncome(paySlipBuilder.getGrossIncome() - paySlipBuilder.getIncomeTax());
        return super.generatePaySlip(paySlipBuilder, employee);
    }
}
