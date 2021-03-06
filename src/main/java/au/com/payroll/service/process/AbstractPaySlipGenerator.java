package au.com.payroll.service.process;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;

/**
 * Abstract decorator class to add functionality dynamically to generate pay slip
 *
 * @author rnadeera
 */
public abstract class AbstractPaySlipGenerator implements PaySlipGenerator {

    private PaySlipGenerator paySlipGenerator;

    public AbstractPaySlipGenerator(PaySlipGenerator paySlipGenerator) {
        this.paySlipGenerator = paySlipGenerator;
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        return paySlipGenerator.generatePaySlip(paySlipBuilder, employee);
    }
}
