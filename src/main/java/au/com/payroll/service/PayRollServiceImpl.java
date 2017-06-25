package au.com.payroll.service;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.service.handler.*;

/**
 * @see {@link PayRollService}
 *
 * @author rnadeera
 */
public class PayRollServiceImpl implements PayRollService {

    private static PayRollService payRollService;

    private PayRollServiceImpl(){

    }

    public static PayRollService getInstance() {
        payRollService = (payRollService == null) ? new PayRollServiceImpl() : payRollService;
        return payRollService;
    }

    @Override
    public PaySlip generatePaySlip(Employee employee) {
        return new PayPeriodDecorator(new GrossIncomeDecorator(new IncomeTaxDecorator(new NetIncomeDecorator(new SuperannuationDecorator(new EmployeePaySlip()))))).generatePaySlip(new PaySlip.PaySlipBuilder(), employee);
    }
}
