package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Concrete decorator to calculate net income
 *
 * @author rnadeera
 */
public class NetIncomeDecorator extends PaySlipDecorator {

    public NetIncomeDecorator(PaySlipHandler paySlipHandler) {
        super(paySlipHandler);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setNetIncome(paySlipBuilder.getGrossIncome() - paySlipBuilder.getIncomeTax());
        return super.generatePaySlip(paySlipBuilder, employee);
    }
}
