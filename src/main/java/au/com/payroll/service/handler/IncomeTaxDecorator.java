package au.com.payroll.service.handler;

import au.com.payroll.domain.IncomeTax;
import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.repository.IncomeTaxRepositoryImpl;
import org.springframework.util.Assert;

/**
 * Concrete decorator to calculate income tax
 *
 * @author rnadeera
 */
public class IncomeTaxDecorator extends PaySlipDecorator {

    public IncomeTaxDecorator(PaySlipHandler paySlipHandler) {
        super(paySlipHandler);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setIncomeTax(calculateTax(employee));
        return super.generatePaySlip(paySlipBuilder, employee);
    }

    private long calculateTax(Employee employee){

        IncomeTax incomeTax = IncomeTaxRepositoryImpl.getInstance().findByIncomeBracket(employee.getAnnualSalary());
        Assert.notNull(incomeTax, "Tax definition not available");

        if(incomeTax.isTaxable()){
            return Math.round((incomeTax.getMarginalTax() + (employee.getAnnualSalary() - incomeTax.getThreshold()) * incomeTax.getUnitRate()) / 12);
        }

        return 0;
    }
}
