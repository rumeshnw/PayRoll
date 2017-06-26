package au.com.payroll.service;

import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.service.handler.*;
import org.springframework.util.Assert;

import java.util.regex.Pattern;

/**
 * @see {@link PayRollService}
 *
 * @author rnadeera
 */
public class PayRollServiceImpl implements PayRollService {

    private static Pattern payPeriodValidator = Pattern.compile("((0)?[1-9]|1[0-2])/20\\d{2}");

    private static PayRollService payRollService;

    private PayRollServiceImpl(){

    }

    public static PayRollService getInstance() {
        payRollService = (payRollService == null) ? new PayRollServiceImpl() : payRollService;
        return payRollService;
    }

    @Override
    public PaySlip generatePaySlip(Employee employee) {
        validate(employee);
        return new PayPeriodDecorator(new GrossIncomeDecorator(new IncomeTaxDecorator(new NetIncomeDecorator(new SuperannuationDecorator(new EmployeePaySlip()))))).generatePaySlip(new PaySlip.PaySlipBuilder(), employee);
    }

    /**
     * Validate @{@link Employee} object
     *
     * if validation failed @{@link IllegalArgumentException} will be thrown
     */
    private void validate(Employee employee){
        Assert.notNull(employee, "employee details required");

        Assert.hasText(employee.getFirstName(), "Employee first name is required");
        Assert.hasText(employee.getLastName(), "Employee last name is required");

        Assert.isTrue(employee.getAnnualSalary() > 0, "Employee annual salary should be a positive value");
        Assert.isTrue(employee.getSuperRate() > 0, "Employee superannuation rate should be a positive value");

        Assert.hasText(employee.getPayPeriod(), "Employee pay paid is required");
        Assert.isTrue(payPeriodValidator.matcher(employee.getPayPeriod()).matches(), "Invalid pay period. Pay period should be in numeric MM/YYYY format");
    }
}