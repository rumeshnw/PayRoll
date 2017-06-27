package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Concrete decorator to calculate superannuation
 *
 * @author rnadeera
 */
public class SuperannuationGenerator extends PaySlipDecorator {

    public SuperannuationGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setSuperannuation(Math.round((paySlipBuilder.getGrossIncome() * employee.getSuperRate()) / 100));
        return super.generatePaySlip(paySlipBuilder, employee);
    }
}