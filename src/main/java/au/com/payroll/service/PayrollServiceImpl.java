package au.com.payroll.service;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.factory.ResourceFactory;
import au.com.payroll.service.process.*;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

/**
 * @see {@link PayrollService}
 *
 * @author rnadeera
 */
public class PayrollServiceImpl implements PayrollService {

    private PaySlipGenerator paySlipGenerator;

    @Override
    public PaySlip generatePaySlip(Employee employee) {
        Assert.notNull(employee, "employee details required");
        return paySlipGenerator.generatePaySlip(new PaySlip.PaySlipBuilder(), employee);
    }

    public void setPaySlipGenerator(PaySlipGenerator paySlipGenerator) {
        this.paySlipGenerator = paySlipGenerator;
    }
}