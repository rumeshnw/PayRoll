package au.com.payroll.service.process;

import au.com.payroll.domain.IncomeTax;
import au.com.payroll.dto.Employee;
import au.com.payroll.dto.PaySlip;
import au.com.payroll.factory.ResourceFactory;
import au.com.payroll.repository.IncomeTaxRespository;
import org.springframework.util.Assert;

/**
 * Concrete decorator to calculate income tax
 *
 * @author rnadeera
 */
public class IncomeTaxGenerator extends AbstractPaySlipGenerator {

    IncomeTaxRespository incomeTaxRespository;

    public IncomeTaxGenerator(PaySlipGenerator paySlipGenerator) {
        super(paySlipGenerator);
    }

    @Override
    public PaySlip generatePaySlip(PaySlip.PaySlipBuilder paySlipBuilder, Employee employee) {
        paySlipBuilder.setIncomeTax(calculateTax(employee));
        return super.generatePaySlip(paySlipBuilder, employee);
    }

    public void setIncomeTaxRespository(IncomeTaxRespository incomeTaxRespository) {
        this.incomeTaxRespository = incomeTaxRespository;
    }

    private long calculateTax(Employee employee){

        IncomeTax incomeTax = incomeTaxRespository.findByIncomeBracket(employee.getAnnualSalary());
        Assert.notNull(incomeTax, "Tax definition not available");

        if(incomeTax.isTaxable()){
            return Math.round((incomeTax.getMarginalTax() + (employee.getAnnualSalary() - incomeTax.getThreshold()) * incomeTax.getUnitRate()) / 12);
        }

        return 0;
    }
}
