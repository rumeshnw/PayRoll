package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * @author rnadeera
 */
public class GrossIncomeDecorator extends PaySlipDecorator {

    public GrossIncomeDecorator(PaySlipHandler paySlipHandler) {
        super(paySlipHandler);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        setGrossIncome(paySlipBuilder, employee);
        return super.generatePaySlip(paySlipBuilder, employee);
    }

    public void setGrossIncome(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee){
        paySlipBuilder.setGrossIncome(Math.round(new Double(employee.getAnnualSalary()) / 12));
    }
}
