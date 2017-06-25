package au.com.payroll.service.handler;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * @author rnadeera
 */
public abstract class PaySlipDecorator extends PaySlipHandler {

    private PaySlipHandler paySlipHandler;

    public PaySlipDecorator(PaySlipHandler paySlipHandler) {
        this.paySlipHandler = paySlipHandler;
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        return paySlipHandler.generatePaySlip(paySlipBuilder, employee);
    }
}
